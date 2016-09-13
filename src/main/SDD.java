/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import utils.*;

/**
 *
 * @author tlvlp
 */
public class SDD {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        /* 
        c:\Users\tlvlp\Documents\sdd_data\
        Map<String,ArrayList<String>> confMap = new HashMap<String,ArrayList<String>>();
        
        
        Create a simplified sequencing data demultiplexer. 
        The tool receives a list of DNA sequences ([ACTG]*) which should be split into groups 
        based on prefix/postfix sequences defined in a simple configuration.
        The tool receives the following input data:
            - path to the sequencing data file: text file, contains one sequence per line,
            - path to the configuration file: text file, each line contains the group name, sequence prefix and postfix separated by ws,
            - path prefix to the output files which serves as a base to generate output filenames for each group.

        If a sequence has matching prefix and postfix it should go into the corresponding group. Sequences not matching any group should go into the 'unmatched' group.

        Runtime performance is not a priority.
        */
        
        //file locations - simplified for the sake of portability
        String confPath = "c:\\Temp\\sdd_data\\sample.conf"; 
        String seqPath = "c:\\Temp\\sdd_data\\sample.seq";
        String outPref = "c:\\Temp\\sdd_data\\output\\";
        
        //parse the .conf file to a map
        Map<String,ArrayList<String>> confMap = InputParser.parseConf(confPath);
        
        //parse the .seq file to an ArrayList
        ArrayList<String> seqList = InputParser.parseToArrayList(seqPath);
        
        //sort the contents of seqList into the groups defined in confMap
        Map<String,ArrayList<String>> seqSorted = SeqSort.sort(confMap, seqList);
        
        //wirte the seqSorted map into output files
        OutputWriter.save(outPref, seqSorted);
        
    }
    
}
