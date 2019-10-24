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
public class AddressVerification {
    
    String[] address;
    
    public AddressVerification() {
        
    }
    
    public boolean validateAddress(String add){
        
        boolean isValid = true;
        try {
            if (this.checkFormat(add) && this.checkStreetAdd(address[0]) &&
                    this.checkCity(address[1]) && this.checkStateZip(address[2])) {
                isValid = true;
            }
        }
        catch (InvalidAddressException e) {
            System.out.println(e.getMessage());
            isValid = false;
        }
        return isValid;
    }
    
    public boolean checkCity(String city) throws InvalidAddressException {
        
        boolean isValid;
        
        if (city.trim().length() > 2) {
            isValid = true;
        }
        else {
            isValid = false;
            throw new InvalidAddressException("You have entered an invalid city, goodbye.");
        }
        
        return isValid;
        
    }
    
    public boolean checkFormat(String sAddress) throws InvalidAddressException {
        
        boolean isValid = true;
        
        address = sAddress.split(",");
        
        if (address.length != 3) {
            isValid = false;
            throw new InvalidAddressException("You have entered an invalid address, goodbye.");
        }
        
        return isValid;
        
    }
    
    public boolean checkStateZip(String stateZip) throws InvalidAddressException {
        
        boolean isValid = true;
        String newZip = stateZip.trim();
        String[] zipCode = newZip.split(" ");
        
        if (zipCode.length < 2) {
            isValid = false;
            throw new InvalidAddressException("You have entered an invalid state, goodbye.");
        }
        else if (zipCode[0].length() != 2) {
            isValid = false;
            throw new InvalidAddressException("You have entered an invalid state, goodbye.");
        }
        else {
            if(zipCode[1].length() != 5) {
                isValid = false;
                throw new InvalidAddressException("You have entered an invalid zipcode, goodbye.");
            }
            else {
                
                for (int i = 0; i < 5; i++) {
                    if (zipCode[1].charAt(i) < 48 || zipCode[1].charAt(i) > 57) {
                        isValid = false;
                        throw new InvalidAddressException("You have entered an invalid zipcode, goodbye.");
                    }
                }
            }
            
        }
        
        
        return isValid;
        
    }
    
    public boolean checkStreetAdd(String streetAdd) throws InvalidAddressException {
        
        boolean isValid = true;
        String newStreet = streetAdd.trim();
        String[] street = newStreet.split(" ");
        
        if (street.length < 2) {
            isValid = false;
            throw new InvalidAddressException("You have entered an invalid street address, goodbye.");
        }
        else if (street.length >= 2) {
            if (street[1].length() < 2) {
                isValid = false;
                throw new InvalidAddressException("You have entered an invalid street name, goodbye.");
            }
            
            for (int i = 0; i < street[0].length(); i++) {
                if (street[0].charAt(i) < 48 || street[0].charAt(i) > 57) {
                    isValid = false;
                    throw new InvalidAddressException("You have entered an invalid street number, goodbye.");
                }
            }
        }
        
        return isValid;
        
    }
}
