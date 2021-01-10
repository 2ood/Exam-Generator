public class Iteration {
    private int bigIndex;
    private int smallIndex;
    private int problemIndex;
    
    protected Iteration() {this(-1,-1,-1);}
    public Iteration(int b, int s, int p) {
        bigIndex =b;
        smallIndex = s;
        problemIndex = p;
    }
    
    public int getBigIndex() {return bigIndex;}
    public int getSmallIndex() {return smallIndex;}
    public int getProbIdx() {return problemIndex;}
    
    public boolean setBig(int b) { bigIndex=b; return true;}
    public boolean setSmall(int s) { smallIndex=s; return true;}
    public boolean setProbIdx(int p) { problemIndex=p; return true;}
    
    
}