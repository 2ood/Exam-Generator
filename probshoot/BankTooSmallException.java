package probshoot;

import java.io.*;

public class BankTooSmallException extends Exception {
    static final long serialVersionUID=1l;
    public BankTooSmallException(String msg) {
        super(msg);
    }
    
    public BankTooSmallException() {
        super();
    }
    
    public String getMessage(){
        return "The problem bank is too small";
    }
}