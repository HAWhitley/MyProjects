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
public class Main {
     public static void main(String[] args) {
        AddressVerification address;
        address = new AddressVerification();
         
        boolean isValid;
        isValid = address.validateAddress("123 OldBirch, Wren, SC 29305");
        
        System.out.println(isValid);
     }
}
