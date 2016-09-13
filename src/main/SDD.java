
package main;
import java.io.IOException;
import java.util.ArrayList;
import utils.*;

/**
 * @author tlvlp
 */
public class SDD {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        //file locations
        String confPath = "c:\\Temp\\sdd_data\\sample.conf"; 
        String seqPath = "c:\\Temp\\sdd_data\\sample.seq";
        String outPref = "c:\\Temp\\sdd_data\\output\\";
        
        //parse the .conf file to a map
        ArrayList<Group> groups = InputParser.parseConf(confPath);
        
        //parse the .seq file to an ArrayList
        ArrayList<String> seqList = InputParser.parseFileToAL(seqPath);
        
        //sort the contents of seqList into the groups defined in confMap
        ArrayList<Group> groupsSeq = SeqSort.sort(groups, seqList);
        
        //wirte the seqSorted map into output files
        OutputWriter.save(outPref, groupsSeq);
    }
}
