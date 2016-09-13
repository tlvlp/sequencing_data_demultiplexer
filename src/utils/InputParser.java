/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.*;
import java.util.*;

/**
 * @author tlvlp
 */
public class InputParser {
    
    public static Map<String, ArrayList<String>> parseConf(String inPath) throws IOException {
    //stores each line of the input file as a map item
        System.out.println("Input file: " + inPath);
       
        Map<String,ArrayList<String>> confMap = new HashMap<>();
        ArrayList<String> mapItems = new ArrayList<>();
        
        try (final Scanner inFile = new Scanner(new FileReader(inPath))) { 
            while (inFile.hasNextLine()) {
                //parse current line into an arraylist - might be overkill to use arraylists..
                mapItems = parseStrToALString(inFile.nextLine(),' ');
                //remove the first ArrayList item to get the desired format for the map: String + ArrayList with two items
                String group = mapItems.get(0);
                mapItems.remove(0); 
                //add values to the output map
                confMap.put(group,mapItems);
            }
        }
        return confMap;
    }
    
    public static ArrayList<String> parseStrToALString(String strIn, Character delimiter) {
    //parses the input String into an ArrayList of Strings with a given delimiter
        ArrayList<String> outList = new ArrayList<>();
        String strColl = "";
        int listCnt = 0;     
        int strLen = strIn.length();
        
        for (int i=0; i<strLen; ++i) {
            //if reached the delimiter or the end of the string save the currently collected string to the current list item
            if (i == strLen-1) {
                strColl = strColl + strIn.charAt(i);
                outList.add(strColl);
                strColl = "";
            }if (strIn.charAt(i) == delimiter) {
                outList.add(strColl);
                strColl = "";
            } else {
                strColl = strColl + strIn.charAt(i);
            }    
        }
        return outList;
    }
    
    public static ArrayList<String> parseToArrayList(String inPath) throws IOException {
    //stores each line of the input file as an arraylist item
 
        ArrayList<String> outList = new ArrayList<>();
        //Setting the path to the given folder under the current user's home/Documents directory
        String inputFile = inPath;
        
        try (final Scanner inFile = new Scanner(new FileReader(inputFile))) {
            outList = new ArrayList<>();
            while (inFile.hasNextLine()) {
                outList.add(inFile.nextLine());
            }
        }
        return outList;
    }
}
