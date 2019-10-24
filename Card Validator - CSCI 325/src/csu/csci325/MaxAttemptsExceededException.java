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
public class MaxAttemptsExceededException extends Exception {
    
    public MaxAttemptsExceededException() {
        super("Max Attempts Exceeded Exception Thrown");
    }
    
    public MaxAttemptsExceededException(String s) {
        super(s);
    }
}
