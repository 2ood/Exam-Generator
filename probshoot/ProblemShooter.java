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
    static File dir;
    static String bankPath;
    static int [][] chapters;
    static String [] bigIndexes;
    static String [][] smallIndexes;
    static  FileWriter log;
    static  FileWriter err;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmm");  
    static LocalDateTime now = LocalDateTime.now();
    static ArrayList <Problem> problems = new ArrayList<Problem>();
    static ArrayList <IterateIndex> indexes = new ArrayList<IterateIndex>();
    
    public static void main (String [] args) {
        try {
            try {
                System.setOut(new PrintStream(new FileOutputStream("log.txt", true)));
                System.setErr(new PrintStream(new FileOutputStream("error.txt", true)));
            } catch(Exception e) {       
                System.err.println("file output error");
                throw new Exception();
            }

            System.out.append("___________NEW RUN in "+dtf.format(now)+"___________"+"\n");
            System.err.append("___________NEW RUN in "+dtf.format(now)+"___________"+"\n");

            System.out.append("reading configuration ...");
            readConfig();
            System.out.append("done"+"\n");

            System.out.append("refreshing chapter data ...");
            refreshChapters();
            System.out.append("done"+"\n");

            System.out.append("choosing Indexes ...");
            indexes=chooseSmallIndex(number);
            System.out.append("done"+"\n");


            System.out.append("reading each problems ...");
            problems = readEachProblem(indexes);
            System.out.append("done"+"\n");


            System.out.append("shuffling problems ...");
            //Collections.shuffle(problems);
            System.out.append("done"+"\n");


            System.out.append("exporting exam sheet ...");
            printToTxt(problems);
            System.out.append("done"+"\n");

            System.out.append("exporting answer sheet ...");
            printAnsTxt();
            System.out.append("All done"+"\n");
        
        
        System.out.append("___________NORMAL PROGRAM EXIT___________"+"\n");
        System.err.append("NORMAL PROGRAM EXIT"+"\n");
            
        } catch (Exception e) {
            System.err.append("\n"+"!!!!!!!!!!!PROGRAM HAD A PROBLEM!!!!!!!!!!!"+"\n");
            System.out.append("\n"+"!!!!!!!!!!!PROGRAM HAD A PROBLEM!!!!!!!!!!!"+"\n");
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
    
    public static void readConfig() throws Exception {
        try {
            ArrayList<ConfigAttr> conf = util.readConfigFile(new File("config.txt"));

            System.out.append("\n"+"\n******configuration********"+"\n");
            for(ConfigAttr c : conf) {
                System.out.append(c.toString()+"\n");
                if(c.equals("Bank-Root:")){bankPath=c.getVar();}
                else if(c.equals("How-Many-Questions(integer):")){number=Integer.parseInt(c.getVar());}
                else continue;
            }
            System.out.append("***************************\n"+"\n");

        } catch(FileNotFoundException f) {
            System.err.append("file"+"\n");
            System.out.append("so little bank"+"\n");
            throw new Exception();
        } catch(Exception e) {
            System.err.append("Unknown exception in method Problemshooter.readConfig"+"\n");
            System.err.append(e.getMessage()+"\n");
            System.err.append("Contact developer.<kmchoi28@naver.com>"+"\n");
            throw new Exception();
        }
    }
    
    public static void refreshChapters() throws Exception {
        try {
            File dir= new File(bankPath);

            if(dir.isDirectory()) {
                String[] subDir = dir.list(new FilenameFilter() {
                  @Override
                  public boolean accept(File current, String name) {
                    return new File(current, name).isDirectory();
                  }
                });
                if(subDir.length<=0) throw new BankTooSmallException();

                Arrays.sort(subDir);

                bigIndexes=subDir;
                smallIndexes= new String[bigIndexes.length][];
                chapters = new int[subDir.length][];
                
                for(int i=0;i<subDir.length;i++) {
                    
                    File[] fileList =(new File(bankPath+"/"+subDir[i])).listFiles();
                    if(fileList.length<=0) throw new BankTooSmallException();
                    Arrays.sort(fileList);

                    chapters[i]=new int[fileList.length];
                    smallIndexes[i]= new String[fileList.length];

                    for(int j=0;j<fileList.length;j++) {
                        chapters[i][j] = util.overlookFile(fileList[j]);
                        smallIndexes[i][j] = fileList[j].getName();
                    }
                }
            }
            else throw new BankTooSmallException();
        } catch (FileNotFoundException e) {
            System.err.append("File not found error in method Problemshooter.refreshChapters"+"\n");
            throw new Exception();
        } catch (BankTooSmallException b) {
            System.err.append("so little bank"+"\n");
            System.out.append("so little bank"+"\n");
            System.out.append("The bank path might not have been properly put. check config.txt"+"\n");
            System.out.append("Or, the bank might not have nothing inside."+"\n");
            System.err.append("The bank path might not have been properly put. check config.txt"+"\n");
            System.err.append("Or, the bank might not have nothing inside."+"\n");
            System.out.append("Exiting program ..."+"\n");
            throw new Exception();
        } catch (Exception e) {
            System.err.append("Unknown error in method Problemshooter.refreshChapters"+"\n");
            System.err.append(e.getMessage()+"\n");
            System.err.append("Contact developer.<kmchoi28@naver.com>"+"\n");
            throw new Exception();
        }
    }
    
    public static ArrayList<IterateIndex> chooseSmallIndex(int count) throws Exception { 
        try {
        ArrayList<IterateIndex> result = new ArrayList<IterateIndex>(count);
        ArrayList<IterateIndex> smalls = new ArrayList<IterateIndex>();
        int indexNum=0;
        
            for(int i=0;i<chapters.length;i++) {
                int [] temp = chapters[i];
                indexNum+=temp.length;
                
                for(int j=0; j<temp.length;j++) {
                    smalls.add(new IterateIndex(bankPath,bigIndexes[i],smallIndexes[i][j]));
                }
            }
            if(indexNum>=count) {
            for(Integer n : chooseNumbers(indexNum,count)) {
                     result.add(smalls.get(n.intValue()));            
                }
            }
            else throw new BankTooSmallException();
        result.trimToSize();
        Collections.sort(result);
        return result;
        } catch (BankTooSmallException b) {
            System.err.append("so little bank"+"\n");
            System.out.append("so little bank"+"\n");
            System.out.append("Exiting program ..."+"\n");
            throw new Exception();
        } catch (Exception e) {
            System.err.append("Unknown error in method Problemshooter.chooseSmallIndex"+"\n");
            e.printStackTrace();
            System.err.append(e.getMessage()+"\n");
            System.err.append("Contact developer.<kmchoi28@naver.com>"+"\n");
            throw new Exception();
        }
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
    
    public static void printToTxt(ArrayList <Problem> problems) throws Exception {
       try {
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
        } catch (FileNotFoundException f) {
            System.err.append("File not found error in method Problemshooter.printToTxt"+"\n");
            throw new Exception();
        } catch (Exception e) {
            System.err.append("Unknown error in method Problemshooter.printToTxt"+"\n");
            System.err.append(e.getMessage()+"\n");
            System.err.append("Contact developer.<kmchoi28@naver.com>"+"\n");
            throw new Exception();
         }
             
        
    }
    
    public static void printAnsTxt() throws Exception {
        try {    
            File file = new File(dtf.format(now)+"answer.txt");
            FileWriter fw = new FileWriter(file);
            int i=1;
     
            for(Problem p : problems) {
                fw.write(i+") "+p.getAnswer()+"\t\t (from "+p.getResourcePath()+") \n");
                fw.flush();
                i++;
            }  
            
            fw.close();
        
        } catch (FileNotFoundException f) {
            System.err.append("File not found error in method Problemshooter.printAnsTxt"+"\n");
            throw new Exception();
        } catch (Exception e) {
            System.err.append("Unknown error in method Problemshooter.printAnsTxt"+"\n");
            System.err.append(e.getMessage()+"\n");
            System.err.append("Contact developer.<kmchoi28@naver.com>"+"\n");
            throw new Exception();
         }
    }
    
    public static ArrayList<Problem> readEachProblem(ArrayList <IterateIndex> chosen) throws Exception {
        try {
            ArrayList<Problem> result= new ArrayList<Problem>();
            Problem newProb;
            IterateIndex i;
            for (int j=0;j<chosen.size();j++) {
                i = chosen.get(j);
                newProb = i.loadProblem(-1);
                newProb.setResourcePath(i.toString());
                result.add(newProb);
            }

            return result;
        } catch (NullPointerException n) {
            System.err.append("NullPointerException occured in ProblemShooter.readEachProblem(ArrayList<T>)"+"\n");
            System.err.append("indexes might not have been initialized"+"\n");
            throw new Exception();
        } catch (Exception e) {
            System.err.append("Unknown error in method ProblemShooter.readEachProblem(ArrayList<T>)"+"\n");
            System.err.append(e.getMessage()+"\n");
            System.err.append("Contact developer.<kmchoi28@naver.com>"+"\n");
            throw new Exception();
         }
    }
     
    public static String shootProb(Problem p, int j) {
        String result="";
        int r = (int)(Math.random()*5);
        p.setAnswer(r+1);
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