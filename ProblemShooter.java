import java.util.*;
import java.io.*;

public class ProblemShooter {
    public static Utility util = new Utility();
    
    public static void main (String [] args) {
        
        ArrayList <Problem> problems;
        ArrayList <IterateIndex> indexes;
        final int NUMBER=10;
        boolean [] turnIn;
        int score;
        
        indexes=chooseSmallIndex(NUMBER);
        problems = readEachProblem(indexes);
        
        int flag =0;
        for(Problem p : problems) {
            System.out.println((flag++)+")"+p.toString());
        }
        //turnIn = exam(problems);
        //score = evaluate(turnIn);
        //System.out.println("The Score is : "+score);
        
        /*//test for choosing random smallindexes.
        int flag =0;
        for(IterateIndex i : indexes) {
                System.out.println((flag++)+" ) "+i.toString());
            }
        */
        
    }
    /*
    public static String[] readFile(String filename) throws Exception {
        String[] temp = new String [100];
        
            Scanner scan = new Scanner(new File(filename));
            int flag=0;
             while(scan.hasNextLine()){
                 temp[flag++] = scan.nextLine();
             }
        // System.out.println("flag : "+flag);
        String [] result = new String[flag];
        for(int i=0; i<result.length;i++) result[i]=temp[i];
        
        return result;
    }
    */
    
    public static ArrayList<IterateIndex> chooseSmallIndex(int count) { 
        ArrayList<IterateIndex> result = new ArrayList<IterateIndex>(count);
        ArrayList<IterateIndex> smalls = new ArrayList<IterateIndex>();
        ArrayList<String> chapters;
        int indexNum=0;
        
        try { 
            chapters = util.readFile("chapters.txt"); 
            for(int i=0;i<chapters.size();i++) {
                String[] temp = chapters.get(i).split(",");
                int [] jay = new int[temp.length];
                
                for(int k=0;k<jay.length;k++) {
                    jay[k]=Integer.parseInt(temp[k]);
                }
                indexNum+=temp.length;
                
                for(int j=0; j<jay.length;j++) {
                    smalls.add(new IterateIndex(i,j));
                }
            }
            
            
            for(Integer n : chooseNumbers(indexNum,count)) {
                     result.add(smalls.get(n.intValue()));
                    //System.out.println(n.intValue());
                
                }
            
        
        }  
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            result = new ArrayList<IterateIndex>();
        }
        catch (Exception e1) {
            e1.printStackTrace(); 
            result = new ArrayList<IterateIndex>();
        }
        
        Collections.sort(result);
        return result;
    }
    
    public static ArrayList<Integer> chooseNumbers(int range, int count) {
        ArrayList<Integer> result = new ArrayList<Integer>(count);
        int flag =0;
        int temp;
        
        while(flag<count) {
            temp = new Integer((int)(Math.random()*(range+1));
            if(result.contains(temp)) ;
            else { result.add(temp); flag++;}
            
        }
        
        return result;
    }
    
    
    public static ArrayList<Problem> readEachProblem(ArrayList <IterateIndex> chosen) {
        ArrayList<Problem> result= new ArrayList<Problem>();
        
        for (IterateIndex i : chosen) {
            result.add(i.loadAnyProblem());
        }
        
        return result;
    }
    
    public static boolean[] exam(ArrayList<Problem> problems) {
        boolean[] result = {true,true};
        return result;
    }
    
    public static int evaluate(boolean[] turnIn) {
        int result = 0;
        return result;
    }
}