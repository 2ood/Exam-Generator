package probshoot;

/**
* supportive class for project problemshooter.
* This class is an object model of handling small indexes.
* @author Kyungmin Choi <kmchoi28@naver.com>
**/

import java.io.FileNotFoundException;
import java.util.*;

public class IterateIndex implements Comparable<IterateIndex> {
    private int bigIndex;
    private int smallIndex;
    public Utility util = new Utility();
    
    protected IterateIndex() {this(-1,-1);}
    public IterateIndex(int b, int s) {
        bigIndex =b;
        smallIndex = s;
    }
    
    
    public int getBigIndex() {return bigIndex;}
    public int getSmallIndex() {return smallIndex;}
    
    public boolean setBig(int b) { bigIndex=b; return true;}
    public boolean setSmall(int s) { smallIndex=s; return true;}
    
    /*
    public void loadProblems () {
        ArrayList<Problem> result = new ArrayList<Problem>();
        problems = result;
    }
    */
    
    public Problem loadProblem (int index) {
        String filename ="PUT_YOUR_QUESTION_FILES_HERE/"+bigIndex+"/"+bigIndex+"-"+smallIndex+".csv";
        Problem result;
        ArrayList<String> wrong = new ArrayList<String>();
        
        try {
        ArrayList<String> f = util.readFile(filename);
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
    
    public Problem loadAnyProblem() {
        String filename ="PUT_YOUR_QUESTION_FILES_HERE/"+(bigIndex+1)+"/"+(bigIndex+1)+"-"+(smallIndex+1)+".csv";
        Problem result;
        ArrayList<String> wrong = new ArrayList<String>();
        
        try {
        ArrayList<String> f = util.readFile(filename);
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
    
    public String toString() {
        String tostring = "bigIndex : "+bigIndex+", smallIndex : "+smallIndex;
        return tostring;
    }
    
    public int compareTo(IterateIndex target) {
        int result;
        if(target.getBigIndex()>bigIndex) result=-1;
        else if(target.getBigIndex()<bigIndex) result=1;
        else {
            if(target.getSmallIndex()>smallIndex) result=-1;
            else if(target.getSmallIndex()==smallIndex) result=0;
            else result =1;
        }
        
        return result;
    }
    
    public boolean equals(IterateIndex target) {
        if(compareTo(target)==0) return true;
        else return false;
    }
    
}