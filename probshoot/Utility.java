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
}