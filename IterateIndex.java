public class IterateIndex implements Comparable<IterateIndex> {
    private int bigIndex;
    private int smallIndex;
    
    protected IterateIndex() {this(-1,-1);}
    public IterateIndex(int b, int s) {
        bigIndex =b;
        smallIndex = s;
    }
    
    public int getBigIndex() {return bigIndex;}
    public int getSmallIndex() {return smallIndex;}
    
    public boolean setBig(int b) { bigIndex=b; return true;}
    public boolean setSmall(int s) { smallIndex=s; return true;}
    
    public String toString() {
        String tostring = "bigIndex : "+bigIndex+", smallIndex : "+smallIndex;
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