package org.example.Exception;

// thrown when an invalid Lego entry is made:
//   - empty values
//   - itemNumber not a number
public class LegoException extends Exception {
    public LegoException(String message) {
        super(message);
    }
}
