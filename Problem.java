public class Problem {
    //attributes
    private String right;
    private String[] wrong;
    private Iteration iterate;
    
    //constructors
    protected Problem() {this("",new String[]{"","","",""},-1,-1,-1);}
    public Problem(String r, String[] w, int b, int s, int p){
        right       = r;
        wrong       = w;
        iterate     = new Iteration(b,s,p);
    }
    public Problem(String r, String[] w, Iteration itr){
        right       = r;
        wrong       = w;
        iterate     = itr;
    }
    
    public Problem(Iteration itr){
        this("",new String[]{"","","",""},itr);
        right = readRight(itr);
        wrong = readWrong(itr);
    }
    public String readRight(Iteration itr) {
        String r="";
        return r;
    }
    
    public String[] readWrong(Iteration itr) {
        /*
        FileInputStream bank = new FileInputStream("bank.txt");
            Set<Word> wordTree = new TreeSet<Word>();

            while(bank.read()!=-1)
            {
                wordTree.add(makeWord(wordBank));
            }
            wordBank.close();

            System.out.println(wordTree);

        */
        String[] result = {"","","",""};
        return result;  
    }
    //getters
    public String getRight() { return right;}
    public String[] getWrong() { return wrong;}
    public Iteration getItr() { return iterate;}
    
    //setters
    public boolean setRight(String r) { right=r; return true;}
    public boolean setWrong(String[] w) { wrong = w; return true;}
    public boolean setItr(Iteration i){ iterate =i; return true;}
    
    public String toString() { 
        String result="";
        return result;
    }

}