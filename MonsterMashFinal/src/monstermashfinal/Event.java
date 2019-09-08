/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstermashfinal;

import java.util.Random;

/**
 *
 * @author Admin Connor
 */
public class Event {
    
           private String mEventText;
    
    public Event(/*String moveText*/) {
        //mEventText = moveText;
    }
    
    public int generateRand(int upperRange) {
        
        Random rand = new Random();
        
        return rand.nextInt(upperRange) + 1;
    }
    
    public void affectPlayer(SpecialEvent event) {
        
    }
}
