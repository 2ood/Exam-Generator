package question_bank;

import java.util.*;
import java.io.*;

public class Utility {
    public Utility() {}
    
    public ArrayList<String> readFile(String filename) throws Exception {
            ArrayList<String> result = new ArrayList<String>();
            Scanner scan = new Scanner(new File(filename));
             while(scan.hasNextLine()){
                 result.add(scan.nextLine());
             }
        result.trimToSize();
        return result;
    }
    
    public ArrayList<String> readFile(File f) throws Exception {
            ArrayList<String> result = new ArrayList<String>();
            Scanner scan = new Scanner(f);
             while(scan.hasNextLine()){
                 result.add(scan.nextLine());
             }
        result.trimToSize();
        return result;
    }
}