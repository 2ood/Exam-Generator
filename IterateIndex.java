public class IterateIndex implements Comparable<IterateIndex> {
    private int bigIndex;
    private int smallIndex;
    private ArrayList<Problem> problems;
    public Utility util = new Utility();
    
    protected IterateIndex() {this(-1,-1,new ArrayList<Problem>());}
    public IterateIndex(int b, int s, ArrayList<Problem> p) {
        bigIndex =b;
        smallIndex = s;
        problemNums = p;
    }
    
    public IterateIndex(int b, int s, int p) {
        this(b,s,new ArrayList<Problems>(p));
    }
    
    public int getBigIndex() {return bigIndex;}
    public int getSmallIndex() {return smallIndex;}
    public ArrayList<Problem> getProblems(){ return problems;}
    
    public boolean setBig(int b) { bigIndex=b; return true;}
    public boolean setSmall(int s) { smallIndex=s; return true;}
    
    public void loadProblems () {
        ArrayList<Problem> result = new ArrayList<Problem>(p);
        problemNums = result;
    }
    
    public Problem loadProblem (int index) {
        String filename =bigIndex+"/"+smallIndex+"/"+index;
        ArrayList<String> f = util.readFile(filename);
        Problem result = new Problem();
        return result;
    }
    
    public Problem loadAnyProblem() {
        int i= (int)(Math.random()*(problems.size()));
        return loadProblem(i);
    }
    
    public String toString() {
        String tostring = "bigIndex : "+bigIndex+", smallIndex : "+smallIndex;
        for(Problem p : problems) {
            System.out.println(p);
        }
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