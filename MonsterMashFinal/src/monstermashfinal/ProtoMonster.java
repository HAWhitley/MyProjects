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
public class ProtoMonster {
    
                    private String mName;
    private String mKillLine;
    private int mSpeed;
    private int mDistance;
    private boolean mIsDistracted;
    
    public ProtoMonster(String n, String k, int spd, int dist, boolean distract) {
        mName = n;
        mKillLine = k;
        mSpeed = spd;
        mDistance = dist;
        mIsDistracted = distract;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getKillLine() {
        return mKillLine;
    }

    public void setKillLine(String killLine) {
        mKillLine = killLine;
    }

    public int getSpeed() {
        return mSpeed;
    }

    public void setSpeed(int spd) {
        mSpeed = spd;
    }
    
    public int getMonsterDistance() {
        return mDistance;
    }
    
    public void setMonsterDistance(int dist) {
        mDistance = dist;
    }
    
    public boolean getIsDistracted() {
        return mIsDistracted;
    }
    
    public void setIsDistracted(boolean distract) {
        mIsDistracted = distract;
    }
}
