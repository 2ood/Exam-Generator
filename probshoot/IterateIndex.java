package probshoot;

/**
* supportive class for project problemshooter.
* This class is an object model of handling small indexes.
* @author Kyungmin Choi <kmchoi28@naver.com>
**/

import java.io.FileNotFoundException;
import java.util.*;

public class IterateIndex implements Comparable<IterateIndex> {
    private String bigIndex;
    private String smallIndex;
    private String filepath;
    public Utility util = new Utility();
    
    
    protected IterateIndex() {this("PUT_YOUR_QUESTION_FILES_HERE","","");}
    public IterateIndex(String root, String b, String s) {
        bigIndex =b;
        smallIndex = s;
        filepath =root+"/"+bigIndex+"/"+smallIndex;
    }
    
    
    public String getBigIndex() {return bigIndex;}
    public String getSmallIndex() {return smallIndex;}
    
    public boolean setBig(String b) { bigIndex=b; return true;}
    public boolean setSmall(String s) { smallIndex=s; return true;}
    
    
    
    public Problem loadProblem (int index) {
        
        Problem result;
        ArrayList<String> wrong = new ArrayList<String>();
        String[] temp;
        try {
            ArrayList<String> f = util.readFile(filepath);
            if(index<=0) {index =(int)(Math.random()*f.size());}
            if(filepath.endsWith(".csv")) temp = f.get(index).split(",");
            else if (filepath.endsWith(".xls")) temp = f.get(index).split("\t");
            else if (filepath.endsWith(".xlsx")) temp = f.get(index).split("\t");
            else if (filepath.endsWith(".xml")) temp = f.get(index).split("\t");
            else  temp = f.get(index).split(",");
            
            for(int i=3;i<temp.length;i++) {
                wrong.add(temp[i]);
            }
            wrong.trimToSize();

            result = new Problem(index,temp[1],temp[2],wrong);
            

        } catch (FileNotFoundException e1) {
            System.err.append("File not found error in method IterateIndex.loadProblem(int)"+"\n");
            result = new Problem();
        } catch (Exception e) {
            System.err.append("Unknown error in method printAnsTxt"+"\n");
            System.err.append(e.getMessage()+"\n");
            System.err.append("Contact developer.<kmchoi28@naver.com>"+"\n");
            result = new Problem();
        }
        
        return result;
    }
    
    
    public String toString() {
        String tostring = "bigIndex : "+bigIndex+", smallIndex : "+smallIndex;
        return tostring;
    }
    
    public int compareTo(IterateIndex target) {
        int result;
        if(target.getBigIndex().compareToIgnoreCase(bigIndex)>0) result=-1;
        else if(target.getBigIndex().compareToIgnoreCase(bigIndex)<0) result=1;
        else {
            if(target.getSmallIndex().compareToIgnoreCase(smallIndex)>0) result=-1;
            else if(target.getSmallIndex().compareToIgnoreCase(smallIndex)==0) result=0;
            else result =1;
        }
        
        return result;
    }
    
    public boolean equals(IterateIndex target) {
        if(compareTo(target)==0) return true;
        else return false;
    }
    
    /*
    //Deprecated - absorbed by loadProblem(index)
    
    public Problem loadAnyProblem() {
        Problem result;
        ArrayList<String> wrong = new ArrayList<String>();
        
        try {
        ArrayList<String> f = util.readFile(path);
        int index =(int)(Math.random()*f.size());
        String[] temp = f.get(index).split(",");
        
        for(int i=3;i<temp.length;i++) {
            wrong.add(temp[i]);
        }
        wrong.trimToSize();
        
        result = new Problem(index,temp[1],temp[2],wrong);
            
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            result = new Problem();
        } catch (Exception e) {
            e.printStackTrace();
            result = new Problem();
        }

        return result;
    }
    */
    
}