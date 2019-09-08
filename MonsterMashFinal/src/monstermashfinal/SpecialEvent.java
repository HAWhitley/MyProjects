/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstermashfinal;

/**
 *
 * @author Admin Connor
 */
public class SpecialEvent extends Event{
    
              private String mSpecText;
    private boolean mHasWeapon;
    private boolean mIsInjured;
    private boolean mHasMedkit;
    
    public SpecialEvent(String specText, boolean weapon, boolean injured
            , boolean medkit){
        mSpecText = specText;
        mHasWeapon = weapon;
        mIsInjured = injured;
        mHasMedkit = medkit;
    }
    
    public String getSpecText() {
        return mSpecText;
    }
    
    public void setSpecText(String specText) {
        mSpecText = specText;
    }
    
    public boolean getHasWeapon() {
        return mHasWeapon;
    }
    
    public void setHasWeapon(boolean weapon) {
        mHasWeapon = weapon;
    }
    
    public boolean getIsInjured() {
        return mIsInjured;
    }
    
    public void setIsInjured(boolean injured) {
        mIsInjured = injured;
    }
    
    public boolean getHasMedkit() {
        return mHasMedkit;
    }
    
    public void setHasMedkit(boolean medkit) {
        mHasMedkit = medkit;
    }
    
    public SpecialEvent getWhichSpecEvent(SpecialEvent event) {
        
        // Generates a random number between 1-100
        int specRand = this.generateRand(100);
        
        // This whole section is basically a spinner for which event gets called
        if(specRand >= 1 && specRand <= 5) {
            event.setSpecText("You tripped! The monster gains on you.\n");
            /*
             *  Should close gap between player and monster
             */
        }
        else if(specRand >= 6 && specRand <= 10) {
            if(!event.getHasWeapon()) {
                event.setSpecText("You have found a weapon! Type 'Weapon' to "
                        + "use.\n");
                event.setHasWeapon(true);
            }
            else {
                event.setSpecText("You already have a weapon. Type 'Weapon' to "
                        + "use.\n");
            }
        }
        else if(specRand >= 11 && specRand <= 15) {
            if(!event.getIsInjured()) {    
                event.setSpecText("You break your ankle. The injury will "
                        + "prevent you from moving at full speed.\n");
                /*
                 *  Monster speed should be increased here
                 */
                event.setIsInjured(true);
            }
            else {
                event.setSpecText("You are already injured.\n");
            }
        }
        else if(specRand >= 16 && specRand <= 20) {
            if(!event.getHasMedkit()) {    
                event.setSpecText("You have found a Medkit. Type 'Medkit' to "
                        + "use.\n");
                /*
                 *  Reduce monster speed to original value
                 */
                event.setHasMedkit(true);
            }
            else {
                event.setSpecText("You already have a medkit. Type 'Medkit' to "
                        + "use.\n");
            }
        }
        else {
            event.setSpecText("");
        }
        
        return event;
    }
    
    // Allows the user to use their weapon
    public SpecialEvent useWeapon(SpecialEvent event) {
        if(event.getHasWeapon() == true) {
            event.setHasWeapon(false);
            System.out.println("You have used your weapon. You escape from the "
                    + "monster for the time being, but your weapon breaks in "
                    + "the struggle.");
        }
        else {
            System.out.println("You have no weapon.");
        }
        return event;
    }
    
    // Allows the user to use their medkit
    public SpecialEvent useMedkit(SpecialEvent event) {
        if(event.getHasMedkit() && event.getIsInjured()) {
            event.setHasMedkit(false);
            event.setIsInjured(false);
            System.out.println("You use the Medkit on your leg. The "
                    + "brace and painkillers keep the pain at bay while you "
                    + "run.");
        }
        else if (!event.getHasMedkit()) {
            System.out.println("You have no Medkit.");
        }
        else if (!event.getIsInjured()) {
            System.out.println("You have no injury.");
        }
        else {
            System.out.println("Something has gone bad wrong.");
        }
        return event;
    }
}
