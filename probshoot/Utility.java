package probshoot;

/**
* utility class for project problemshooter.
* This class has methods for reading files and exporting it as String arraylist.
* @author Kyungmin Choi <kmchoi28@naver.com>
**/

import java.util.*;
import java.io.*;

public class Utility {
    public Utility() {}
    
    public ArrayList<ConfigAttr> readConfigFile(File f) throws Exception {
            ArrayList<ConfigAttr> result = new ArrayList<ConfigAttr>();
            Scanner scan = new Scanner(f);
             while(scan.hasNextLine()){
                 String next = scan.nextLine();
                 if(next.startsWith("#")) continue;
                 else if(next.endsWith(":")){
                     result.add(new ConfigAttr(next,scan.nextLine()));
                 }
                 else continue;
             }
        scan.close();
        result.trimToSize();
        return result;
    }
    
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
        scan.close();
        result.trimToSize();
        return result;
    }
    
    public int overlookFile(File f) throws Exception {
            int result=0;
            Scanner scan = new Scanner(f);
             while(scan.hasNextLine()){
                 result++;
                 scan.nextLine();
             }
        scan.close();
        return result;
    }
}