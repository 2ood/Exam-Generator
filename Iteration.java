public class Iteration extends IterateIndex {
    private int problemIndex;
    
    protected Iteration() {this(-1,-1,-1);}
    public Iteration(int b, int s, int p) {
        this(new IterateIndex(b,s), p);
    }
    
    public Iteration(IterateIndex i, int p) {
        super(i);
        problemIndex = p;
    }
    
    
    public int getProbIdx() {return problemIndex;}
    
    public boolean setProbIdx(int p) { problemIndex=p; return true;}
    
    public int compareTo(IterateIndex target) {
        int sup = target.compareTo(this);
        if(sup!=0) return sup; 
        else { 
            if(target instanceof Iteration) {
                return (problemIndex > ((Iteration)target).getProbIdx())?-1:((problemIndex < ((Iteration)target).getProbIdx())?1:0); 
            }
            else return sup;
        }
    }
    
    public boolean equals(IterateIndex target) {
        if(compareTo(target)==0) return true;
        else return false;
    }
}