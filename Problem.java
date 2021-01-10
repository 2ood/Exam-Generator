public class Problem {
    //attributes
    private String right;
    private String[] wrong;
    private int bigIndex;
    private int smallIndex;
    private int problemIndex;
    
    //constructors
    public Problem() {this("",new String[]{"","","",""},-1,-1,-1);}
    public Problem(String r, String[] w, int b, int s, int p){
        right       = r;
        wrong       = w;
        bigIndex    = b;
        smallIndex  = s;
        problemIndex= p;
    }
    public Problem(int bigIndex, int smallIndex, int problemIndex){
        this("",new String[]{"","","",""},bigIndex, smallIndex, problemIndex);
        right = readRight(bigIndex, smallIndex, problemIndex);
        wrong = readWrong(bigIndex, smallIndex, problemIndex);
    }
    public String readRight(int bigIndex, int smallIndex, int problemIndex) {
        String r="";
        return r;
    }
    
    public String[] readWrong(int bigIndex, int smallIndex, int problemIndex) {
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
    public int getBigIndex() {return bigIndex;}
    public int getSmallIndex() { return smallIndex;}
    public int getProblemIndex() { return problemIndex;}
    
    //setters
    public boolean setRight(String r) { right=r; return true;}
    public boolean setWrong(String[] w) { wrong = w; return true;}
    public boolean setBigIndex(int b) {bigIndex= b; return true;}
    public boolean setSmallIndex(int s) { smallIndex = s; return true;}
    public boolean setProblemIndex(int p) { problemIndex=p; return true;}
    
    public String toString() { 
        String result="";
        return result;
    }

}