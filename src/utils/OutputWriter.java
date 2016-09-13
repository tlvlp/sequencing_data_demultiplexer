package utils;

import java.io.*;
import java.util.*;

public class OutputWriter {

    public static void save(String outPath, Map<String,ArrayList<String>> seqSorted) throws IOException {
    //loop over the seqSorted map
       //create a new file for each seqSorted map entry
        String filePath = outPath + key + ".seq";
        try (PrintWriter outFile = new PrintWriter(new FileWriter(filePath))) {
            for (int i=0; i<outList.size(); i++) {
                outFile.println(outList.get(i));
            }
        }
    }
    
    public static void saveBackup(String workDir, String module, ArrayList<String> outList) throws IOException {
        //Setting the path to the given folder under the current user's home/Documents directory
        String outputFile = System.getProperty("user.home") + "/Documents/" + workDir + "/rosalind_" + module + "_out.txt";
        
        try (PrintWriter outFile = new PrintWriter(new FileWriter(outputFile))) {
            for (int i=0; i<outList.size(); i++) {
                outFile.println(outList.get(i));
            }
        }
    }
}