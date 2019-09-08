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
public class MainMap {
    
             String mMapName;
    int mTime;
    int mMap;
    
    public MainMap() {
        Random rand = new Random();
        mMap = rand.nextInt(100) + 1;
    }
     
    public String getRandMap() {
        
        if (mMap % 3 == 0) {
            mMapName = "Graveyard";
        }
        else if (mMap % 3 == 1) {
            mMapName = "Jungle";
        }
        else {
            mMapName = "Office";
        }
        
        return mMapName;
        
    }
    
    public int getMapTime() {
        
        if (mMap % 3 == 0) {
            mTime = 600;
        }
        else if (mMap % 3 == 1) {
            mTime = 1200;
        }
        else {
            mTime = 800;
        }
        
        return mTime;
        
    }

    public int instantiateMonster() {
        
        int mapType;
        
        if (mMap % 3 == 0) {
            mapType = 1;
        }
        else if (mMap % 3 == 1) {
            mapType = 2;
        }
        else {
            mapType = 3;
        }
        
        return mapType;
    }
}
