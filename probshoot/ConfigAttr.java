package probshoot;

public class ConfigAttr {
    private String name;
    private String variable;
    
    public ConfigAttr(){this("","");}
    public ConfigAttr(String n, String var) {
        name = n;
        variable = var;
    }
    
    public String getName() {return name;}
    public String getVar() {return variable;}
    
    public boolean equals(ConfigAttr c) {
        return (c.getName().equals(name))?true:false;
    }
    
    public boolean equals(String c) {
        return (c.equals(name))?true:false;
    }
    
    public String toString(){
        return name+" "+variable;
    }
    
}