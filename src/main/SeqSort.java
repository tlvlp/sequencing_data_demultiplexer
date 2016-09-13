/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.util.*;


/**
 *
 * @author tlvlp
 */
public class SeqSort {
    public static Map<String,ArrayList<String>> sort(Map<String,ArrayList<String>> confMap, ArrayList<String> seqList) {
        Map<String,ArrayList<String>> seqSorted = new HashMap<>();
        ArrayList<String> checkStrings = new ArrayList<>();
        ArrayList<String> collectReads = new ArrayList<>();
        String begString ="", endString ="", key="";
        
        //iterat over the confMap's keyset
        Iterator iter = confMap.keySet().iterator();
        while (iter.hasNext()) {
            // iter.next() is the key in confMap
            key = iter.next().toString();
            checkStrings = confMap.get(key);
            begString = checkStrings.get(0);
            endString = checkStrings.get(1);
            //check all reads in the seqlist for the ending and beginning strings in checkStrings
            for (int i=0; i<seqList.size();i++) {
                if (seqList.get(i).startsWith(begString) && seqList.get(i).endsWith(endString)) {
                                       
                    //add read to the collector
                    collectReads.add(seqList.get(i));
                    //overwrite the collected seqList item with an empty string - removing it without messing up the list that we are iterating over
                    seqList.set(i, "");
                }
            }
            //add the collected reads to a new map entry of SeqSorted            
            seqSorted.put(key,collectReads);

            //clear the collector
            collectReads.clear();
            
        }
        //add the remaining reads to the unmatched map entry
        for (int i=0; i<seqList.size();i++) {
            if (!seqList.get(i).equals("")) {
                //add read to the collector
                collectReads.add(seqList.get(i));
                //overwrite the collected seqList item with an empty string - removing it without messing up the list that we are iterating over
                seqList.set(i, "");
                
            }
        }
        //add the collected reads to a new map entry of SeqSorted            
        seqSorted.put("unmatched",collectReads);
        System.out.println(seqSorted);
        
        collectReads.clear();
        return seqSorted;
    }
}
