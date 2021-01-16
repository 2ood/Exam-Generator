public class Utility {
    public Utility() {}
    
    public ArrayList<String> readFile(String filename) throws Exception {
            ArrayList<String> result = new ArrayList<String>();
            Scanner scan = new Scanner(new File(filename));
             while(scan.hasNextLine()){
                 temp.add(scan.nextLine());
             }
        
        return result;
    }
}