public class Problem {
    //attributes
    private String right;
    private AttayList<String> wrong;
    
    //constructors
    public Problem() {this("",new ArrayList<String>());}
    public Problem(String r, AraryList<String> w){
        right       = r;
        wrong       = w;
    }
    
    public String readRight() {
        String r="";
        return r;
    }
    
    public String[] readWrong() {
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
    //setters
    public boolean setRight(String r) { right=r; return true;}
    public boolean setWrong(String[] w) { wrong = w; return true;}
    
    public String toString() { 
        String result="";
        return result;
    }

}