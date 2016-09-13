package utils;

import java.io.*;
import java.util.*;
import main.Group;

public class OutputWriter {

    public static void save(String outPath, ArrayList<Group> seqSorted) throws IOException {
        //loop over the seqSorted map
        for (int i=0;i<seqSorted.size();i++) {
            //create a new file for each seqSorted map entry
            String filePath = outPath + seqSorted.get(i).getName() + ".seq";
            //write the grouped reads to the files
            try (PrintWriter outFile = new PrintWriter(new FileWriter(filePath))) {
                for (int k=0; k<seqSorted.get(i).getReads().size(); k++) {
                    outFile.println(seqSorted.get(i).getReads().get(k));
                }
            }
        }
    }
}