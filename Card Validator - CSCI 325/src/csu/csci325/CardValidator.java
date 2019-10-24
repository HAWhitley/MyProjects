/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csu.csci325;

import java.util.Scanner;

/**
 *
 * @author holly
 */
public class CardValidator {
    
    int maxAttempts = 0;
    
    public CardValidator() {
   
    }
    
    public boolean checkNum(String sCardNum, String sCardType, int iCardType) {
        
        boolean isValid;
        String cardType = sCardType.trim().toLowerCase();
        
        maxAttempts++;
        
        if(cardType.equals("american express") || iCardType == 1) {
            if (sCardNum.charAt(0) == '3' && sCardNum.length() == 15) {
                isValid = true;
            }
            else {
                isValid = false;
            }
        }
        else if (cardType.equals("visa") || iCardType == 2) {
            if (sCardNum.charAt(0) == '4' && sCardNum.length() == 16) {
                isValid = true;
            }
            else {
                isValid = false;
            }
        }
        else if (cardType.equals("mastercard") || iCardType == 3) {
            if (sCardNum.charAt(0) == '5' && sCardNum.length() == 16) {
                isValid = true;
            }
            else {
                isValid = false;
            }
        }
        else if (cardType.equals("discover") || iCardType == 4) {
            if (sCardNum.charAt(0) == '6' && sCardNum.length() == 16) {
                isValid = true;
            }
            else {
                isValid = false;
            }
        }
        else {
            isValid = false;
        }
         
        return isValid;
    }
    
    public boolean checkType(int iType) throws MaxAttemptsExceededException {
        
        boolean isCardType;
        
        maxAttempts++;
        
        if (iType >=1 && iType <= 4) {
            isCardType = true;
        }
        else {
            isCardType = false;

        }
        
        if (maxAttempts > 2) {
            throw new MaxAttemptsExceededException();
        }
        
        return isCardType;
        
    }
    
    public boolean checkType(String sType) throws MaxAttemptsExceededException {
        
        String cardName = sType.trim();
        String newCardName = cardName.toLowerCase();
        boolean isCardType;
        
        maxAttempts++;
        
        if (newCardName.equals("american express")) {
            isCardType = true;
        }
        else if (newCardName.equals("visa")) {
            isCardType = true;
        }
        else if (newCardName.equals("mastercard")) {
            isCardType = true;
        }
        else if (newCardName.equals("discover")) {
            isCardType = true;
        }
        else {
            isCardType = false;
        }
        
        if (maxAttempts > 2) {
            throw new MaxAttemptsExceededException();
        }
        
        return isCardType;
        
    }
    
    public int getAttempts() {
        
        return maxAttempts;
        
    }
    
    public static int getInt() {
        
        int integerInput;
        
        Scanner input = new Scanner(System.in);
        integerInput = input.nextInt();
        
        return integerInput;
        
    }
    
    public static String getString() {
        
        String stringInput;
        
        Scanner input = new Scanner(System.in);
        stringInput = input.nextLine();
        
        return stringInput;
        
    }
}
