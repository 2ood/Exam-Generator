package probshoot;

/**
* main class(Entry-Point) for project problemshooter.
* @author Kyungmin Choi <kmchoi28@naver.com>
**/

import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class ProblemShooter {
    public static Utility util = new Utility();
    static int number;
    static int[] ans;
    static File dir;
    static String bankPath;
    static int [][] chapters;
    
    public static void main (String [] args) {
        
        ArrayList <Problem> problems;
        ArrayList <IterateIndex> indexes;
        
        System.out.print("reading configuration ...");
        readConfig();
        System.out.println("done");
        
        System.out.print("refreshing chapter file ...");
        refreshChapters();
        System.out.println("done");
        
        try {
            System.out.print("choosing Indexes ...");
            indexes=chooseSmallIndex(number);
            System.out.println("done");
        } catch (Exception e) {
            System.out.println("so little bank");
            System.out.println("Exiting program ...");
            return;
        }
        
        System.out.print("reading each problems ...");
        problems = readEachProblem(indexes);
        System.out.println("done");
        
        System.out.print("shuffling problems ...");
        Collections.shuffle(problems);
        System.out.println("done");
        
        
        System.out.print("exporting exam sheet ...");
        printToTxt(problems);
        System.out.println("done");
        
        
        System.out.print("exporting answer sheet ...");
        printAnsTxt();
        System.out.println("All done");
        
        //turnIn = exam(problems);
        //score = evaluate(turnIn);
        //System.out.println("The Score is : "+score);
        
        /*//test for choosing random smallindexes.
        int flag =0;
        for(IterateIndex i : indexes) {
                System.out.println((flag++)+" ) "+i.toString());
            }
        */
        /*// test for loading problem contents.
        int flag =0;
        for(Problem p : problems) {
            System.out.println((flag++)+")"+p.toString());
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
    
    public static void readConfig() {
        try {
            bankPath="PUT_YOUR_QUESTION_FILES_HERE";
            number=10;
            ans = new int[number];
        } catch(Exception e) {}
        
    }
    
    public static void refreshChapters() {
        try {
            File dir= new File(bankPath);
            
            if(dir.isDirectory()) {
                String[] subDir = dir.list(new FilenameFilter() {
                  @Override
                  public boolean accept(File current, String name) {
                    return new File(current, name).isDirectory();
                  }
                });

                Arrays.sort(subDir);

                chapters = new int[subDir.length][];
                for(int i=0;i<subDir.length;i++) {
                    File[] fileList =(new File(bankPath+"/"+subDir[i])).listFiles();
                    Arrays.sort(fileList);
                    
                    chapters[i]=new int[fileList.length];
                    for(int j=0;j<fileList.length;j++) {
                        chapters[i][j] = util.overlookFile(fileList[j]);
                    }
                }
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
         }
        
    }
    
    public static ArrayList<IterateIndex> chooseSmallIndex(int count) throws Exception { 
        ArrayList<IterateIndex> result = new ArrayList<IterateIndex>(count);
        ArrayList<IterateIndex> smalls = new ArrayList<IterateIndex>();
        int indexNum=0;
        
            for(int i=0;i<chapters.length;i++) {
                int [] temp = chapters[i];
                indexNum+=temp.length;
                
                for(int j=0; j<temp.length;j++) {
                    smalls.add(new IterateIndex(i,j));
                }
            }
            if(indexNum>=count) {
            for(Integer n : chooseNumbers(indexNum,count)) {
                     result.add(smalls.get(n.intValue()));            
                }
            }
            else throw new Exception();
        
        Collections.sort(result);
        return result;
    }
    
    public static ArrayList<Integer> chooseNumbers(int range, int count) {
        ArrayList<Integer> result = new ArrayList<Integer>(count);
        int flag =0;
        int temp;
        
        while(flag<count) {
            temp = new Integer((int)(Math.random()*range));
            if(result.contains(temp));
            else { result.add(temp); flag++;}
            
        }
        
        return result;
    }
    
    public static void printToTxt(ArrayList <Problem> problems) {
         try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmm");  
            LocalDateTime now = LocalDateTime.now(); 
            File file = new File(dtf.format(now)+"exam.txt");
            FileWriter fw = new FileWriter(file);
            int i=1;
            for(Problem p : problems) {
                fw.write(i+". ");
                fw.write(shootProb(p,i-1));
                fw.write("\n\n");
                fw.flush();
                i++;
            }  
            
            fw.close();
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
         }
    }
    
    public static void printAnsTxt() {
         try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmm");  
            LocalDateTime now = LocalDateTime.now(); 
            File file = new File(dtf.format(now)+"answer.txt");
            FileWriter fw = new FileWriter(file);
            int i=1;
            for(int a : ans) {
                fw.write(i+") "+a+"\n");
                fw.flush();
                i++;
            }  
            
            fw.close();
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
         }
    }
    
    public static ArrayList<Problem> readEachProblem(ArrayList <IterateIndex> chosen) {
        ArrayList<Problem> result= new ArrayList<Problem>();
        
        for (IterateIndex i : chosen) {
            result.add(i.loadAnyProblem());
        }
        
        return result;
    }
    
   
    
    public static String shootProb(Problem p, int j) {
        String result="";
        int r = (int)(Math.random()*5);
        ans[j]=(r+1);
        String [] outof = p.getOutOf(r);
        //System.out.println(p);
        result+=(p.getPassage()+"\n");
        
        for(int i=0; i<outof.length;i++) {
            result+="("+(i+1)+") "+outof[i]+"\n";
        }
        
        return result;
    }
    /*
     public static boolean[] exam(ArrayList<Problem> problems) {
        boolean[] result = new boolean[problems.size()];
        int flag=0;
        for(Problem p : problems) {
            result[flag]=exam(flag++, p);
            System.out.println("*********************");
        }
        return result;
    }
    
    public static boolean exam(int flag, Problem p) {
        Scanner sc = new Scanner(System.in);
        int r = (int)(Math.random()*5);
        
        String [] outof = p.getOutOf(r);
        //System.out.println(p);
        System.out.println((flag+1)+"."+p.getPassage());
        
        
        for(int i=0; i<outof.length;i++) {
            System.out.println("("+(i+1)+") "+outof[i]);
        }
        
        System.out.print("Your answer : ");
        if(sc.nextInt()==r+1)  {System.out.println("right!"); sc.close();return true; }
        else {System.out.println("Wrong!"); sc.close(); return false; }
    }
    
    public static int evaluate(boolean[] turnIn) {
        int count = 0;
        int result;
        for(int i=0;i<turnIn.length;i++) {
            if(turnIn[i]) count++;
        }
        result = (int)((float)(count)/turnIn.length*100);
        System.out.println("Got "+count+" right out of "+turnIn.length+" problems.");
        
        return result;
    }
    */
}