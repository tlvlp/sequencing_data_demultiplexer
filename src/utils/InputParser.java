/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.*;
import java.util.*;
import main.Group;

/**
 * @author tlvlp
 */
public class InputParser {
    
    
    public static ArrayList<Group> parseConf(String inPath) throws IOException {
    //stores each line of the input file as a Group class        
        ArrayList<Group> groups = new ArrayList<>();
       
        try (final Scanner inFile = new Scanner(new FileReader(inPath))) { 
            while (inFile.hasNextLine()) {
                //initializing a new version of thisGroup and lineItems at the beginning of each iteration, otherwise it would only overwrite the same value
                Group thisGroup = new Group();
                ArrayList<String> lineItems = new ArrayList<>();
                //parse current line into an arraylist - might be overkill to use arraylists..
                lineItems = parseStrToALString(inFile.nextLine(),' ');
                //remove the first ArrayList item to get the desired format for the map: String + ArrayList with two items
                thisGroup.setName(lineItems.get(0));
                thisGroup.setBeg(lineItems.get(1));
                thisGroup.setEnd(lineItems.get(2));
                groups.add(thisGroup);
                //adding unmatched collector group at the end
                if (!inFile.hasNextLine()) {
                    Group unmatched = new Group();
                    unmatched.setName("unmatched");
                    groups.add(unmatched);
                }
            }
        }
        return groups;
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
    
    public static ArrayList<String> parseFileToAL(String inPath) throws IOException {
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
