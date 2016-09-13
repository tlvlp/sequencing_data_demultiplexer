/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author tlvlp
 */
public class Group {
    private String groupName;
    private String begString;
    private String endString;
    private ArrayList<String> readsCollected = new ArrayList<>();    
    
    public Group (){
        groupName = "";
        begString = "";
        endString = "";
        //readsCollected is already initialized
    }
    
    public Group (String g, String b, String e, ArrayList<String> r){
        groupName = g;
        begString = b;
        endString = e;
        readsCollected = r;
    }
    
    public String getName() {
        return groupName;
    }
    public String getBeg() {
        return begString;
    }
    public String getEnd() {
        return endString;
    }
    public ArrayList<String> getReads() {
        return readsCollected;
    }
    
    public void setName(String g) {
        groupName = g;
    }
    public void setBeg(String b) {
        begString = b;
    }
    public void setEnd(String e) {
        endString = e;
    }
    public void setReads(ArrayList<String> r) {
        readsCollected = r;
    }
    public void clear(){
        groupName = "";
        begString = "";
        endString = "";
        readsCollected.clear();
    }
}
