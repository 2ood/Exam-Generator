import java.util.*;
import java.io.*;

public class ProblemShooter {
    public static void main (String [] args) {
        
        String fileName="";
        ArrayList <Problem> problems;
        int [] indexes;
        final int NUMBER=40;
        boolean [] turnIn;
        int score;
        fileName="chapters.txt";
        indexes=chooseSmallIndex(NUMBER);
        
        //problems = readEachProblem(indexes);
        //turnIn = exam(problems);
        //score = evaluate(turnIn);
        
        //System.out.println("The Score is : "+score);
        
        
    }
    public static String[] readFile(String filename) throws Exception {
        String[] temp = new String [100];
        
            Scanner scan = new Scanner(new File("chapters.txt"));
            int flag=0;
             while(scan.hasNextLine()){
                 temp[flag++] = scan.nextLine();
             }
        System.out.println("flag : "+flag);
        String [] result = new String[flag];
        for(int i=0; i<result.length;i++) result[i]=temp[i];
        
        return result;
    }
    
    public static int[] chooseSmallIndex(int count) { 
        int[] result;
        int [] chapterNums = new int [40];
        String []  chapters;

        try { 
            chapters = readFile("chapters.txt"); 
            //for(int i=0; i<chapters.length;i++) System.out.println("chapters["+i+"] : "+chapters[i]);
            result = new int[count];
                for(int i=0; i<result.length; i++) {
                    //System.out.println(chapterNums[i]);
                    result[i]= (int)(Math.random()*chapterNums[i]+1);    
                }
        
        }  
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            result = new int[]{-1,-1,-1,-1};
        }
        catch (Exception e1) {e1.printStackTrace(); result = new int[]{-1,-1,-1,-1};}
        return result;
    }
    
    public static ArrayList<Integer> chooseNumbers(int range, int count) {
        ArrayList<Integer> result = new ArrayList<Integer>(count);
        int flag =0;
        int temp;
        while(flag<count) {
            temp = new Integer((int)(Math.random()*range +1));
            if(result.contains(temp)) ;
            else { result.add(temp); flag++;}
        }
        
        return result;
    }
    
    
    public static ArrayList<Problem> readEachProblem(int[] indexes) {
        ArrayList<Problem> result= new ArrayList<Problem>();
        Problem newProb;
        
        for (int i=0;i<40;i++) {
            newProb = new Problem();
            result.add(newProb);
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