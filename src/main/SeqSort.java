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
    public static ArrayList<Group> sort(ArrayList<Group> groups, ArrayList<String> seqList) {
        ArrayList<Group> groupsSeq = new ArrayList<>();
        //iterate over the groups
        for (int i=0;i<groups.size();i++) {
            //init read collector and group to be modified and saved back to the list
            ArrayList<String> readCollector = new ArrayList<>();
            Group thisGroup = new Group();
            thisGroup = groups.get(i);
            String begString,endString;
            begString = groups.get(i).getBeg();
            endString = groups.get(i).getEnd();
            
            //iterate over the read list
            for (int k=0; k<seqList.size();k++) {                
                
                if (seqList.get(k).startsWith(begString) && seqList.get(k).endsWith(endString)) {                                        
                    //add read to the collector
                    
                    readCollector.add(seqList.get(k));                    
                    //overwrite the collected seqList item with an empty string - removing it without messing up the list that we are iterating over
                    
                    //seqList.set(k, "*");
                    seqList.remove(k);
                }
            }
            thisGroup.setReads(readCollector);
            groupsSeq.add(thisGroup);
        }
        return groupsSeq;
    }
}