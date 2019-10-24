/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csu.csci325;

/**
 *
 * @author holly
 */
public class InvalidAddressException extends Exception {
    
    public InvalidAddressException() {
        super("Invalid Address Exception Thrown");
    }
    
    public InvalidAddressException(String s) {
        super(s);
    }
    
    
}
