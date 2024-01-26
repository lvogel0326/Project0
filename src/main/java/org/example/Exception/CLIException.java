package org.example.Exception;

// mis-use of console input
//   - enter anything other than Add or View
public class CLIException extends Exception{
    public CLIException(String message){
        super(message);
    }
}
