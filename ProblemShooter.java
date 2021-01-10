public class ProblemShooter {
    public static void main (String [] args) {
        String fileName="";
        ArrayList <Problem> problems;
        int [] indexes;
        final int NUMBER=40;
        boolean [] turnIn;
        int score;
        
        fileName=fileChoose();
        indexes=chooseSmallIndex();
        problems = readEachProblem(NUMBER, indexes, fileName);
        turnIn = exam(problems);
        score = evaluate(turnIn);
        
        System.out.println("The Score is : "+score);
    }
    
    public static String fileChoose() {
        String fileName = "";
        return fileName;
    }
    
    public static int[] chooseSmallIndex() { 
        int[] result=new int[]{0,0,0};
        return result;
    }
    
    public static ArrayList<Problem> readEachProblem(int number, int[] indexes, String fileName) {
        ArrayList<Problem> result= new ArrayList<Problem>();
        
        for (int i=0;i<number;i++) {
            
        }
    }
    
    public static boolean[] exam(ArrayList<problem> problems) {
        boolean[] result = {true,true};
        return result;
    }
    
    public static int evaluate(boolean[] turnIn) {
        int result = 0;
        return result;
    }
}