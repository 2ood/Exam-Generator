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
        
        fileName=fileChoose();
        indexes=chooseSmallIndex(NUMBER);
        //problems = readEachProblem(indexes, fileName);
        //turnIn = exam(problems);
        //score = evaluate(turnIn);
        
        //System.out.println("The Score is : "+score);
        
        
    }
    
    public static String fileChoose() {
        String fileName = "chapters.txt"; //chapters.txt has the number of smallIndexes for each 
        return fileName;
    }
    
    public static int[] chooseSmallIndex(int count) { //finished
        int[] result;
        int [] chapterNums = new int [40];
        
        try {
            Scanner scan = new Scanner(new File("chapters.txt"));
            int flag=0;
             while(scan.hasNextLine()){
                 chapterNums[flag++] = Integer.parseInt(scan.nextLine());
             }

            result = new int[flag];
                for(int i=0; i<result.length; i++) {
                    System.out.println(chapterNums[i]);
                    result[i]= (int)(Math.random()*chapterNums[i]+1);    
                }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            result = new int[]{-1,-1,-1,-1};
        }
        catch (Exception e1) {e1.printStackTrace(); result = new int[]{-1,-1,-1,-1};}
        return result;

    }
    
    public static ArrayList<Problem> readEachProblem(int number, int[] indexes, String fileName) {
        ArrayList<Problem> result= new ArrayList<Problem>();
        
        for (int i=0;i<number;i++) {
            
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