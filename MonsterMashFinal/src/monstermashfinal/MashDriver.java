/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstermashfinal;

import java.util.Scanner;

/**
 *
 * @author Admin Connor
 */
public class MashDriver {
    
            public static void main(String[] args) {
        
         String input;
         int playerSpeed = 0;
         int initialSpeed = 0;
         int monsterNo = 0;

    MainMap map = new MainMap();
    MoveEvent move = new MoveEvent("", false, false, false, false);
    MoveEvent lastEvent = new MoveEvent("", false, false, false, false);
    SpecialEvent special = new SpecialEvent("", false, false, false);
    ProtoMonster monster = new ProtoMonster("", "", 0, 0, false);
    monsterNo = map.instantiateMonster();
        
    
    String mapName = map.getRandMap();
    int mapDistance = map.getMapTime();
    
    
    System.out.println();
    System.out.println("location: " + mapName);
    System.out.println("initial Distance from exit: " + mapDistance);
    monsterNo = map.instantiateMonster();
    
            if(monsterNo == 1){
            monster = new ProtoMonster("Dracula", "Seven, Seven Bats!", 35, 700, false);
                playerSpeed = 45;
                initialSpeed = 45;
        }
        else if(monsterNo == 2){
            monster = new ProtoMonster("Tribe", "You did not know de way!", 65, 1000, false);
                playerSpeed = 75;
                initialSpeed = 75;
        }
        else if(monsterNo == 3){
            monster = new ProtoMonster("Michael", "if i had a gun with two bullets and i " + 
                    "was in a room with you, i'd shoot you twice. \n*Michael shoots you twice*", 50, 900, false);
                playerSpeed = 60;
                initialSpeed = 60;
        }
    System.out.println("Monster inital Distance: " + monster.getMonsterDistance());
    System.out.println("");
    
    while(mapDistance > 0 && monster.getMonsterDistance() > 0){
    
        move = move.getWhichMoveEvent(map.instantiateMonster());
        special = special.getWhichSpecEvent(special);
        
        while(move.getMoveText() == lastEvent.getMoveText()){
            move = move.getWhichMoveEvent(map.instantiateMonster());
        }
        
        lastEvent = move;
        
        System.out.println(move.getMoveText());
        System.out.println();
        System.out.print(special.getSpecText());
        System.out.println();

        
        System.out.print("-OPTIONS MENU-            ");
        System.out.println("-STATUS & INVENTORY-");
        System.out.print("forward                   ");
        System.out.println("Weapon: " + special.getHasWeapon());
        System.out.print("backward                  ");
        System.out.println("Injured: " + special.getIsInjured());
        System.out.print("left                      ");
        System.out.println("Medkit: " + special.getHasMedkit());
        System.out.println("right");
        System.out.println("weapon");
        System.out.println("medkit");
        System.out.println("exit");
        
        System.out.println();       
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().toLowerCase();
        if(input.equals("exit"))
            break;
       

        if(special.getIsInjured() == true)
            playerSpeed = playerSpeed - 1;

        if(special.getIsInjured() == false)
            playerSpeed = initialSpeed;
       
        while(!input.equals("forward") && !input.equals("backward") && !input.equals("left") &&
                !input.equals("right") && !input.equals("weapon") && !input.equals("medkit") &&
                !input.equals("exit")){
            
            System.out.println("Invalid input! Please input one of the following:");
            System.out.println("forward");
            System.out.println("backward");
            System.out.println("left");
            System.out.println("right");
            System.out.println("weapon");
            System.out.println("medkit");
            System.out.println("exit");
            System.out.println();
            input = scanner.nextLine().toLowerCase();
        }
        
        if(input.equals("forward") && move.getMoveForward() != false){
            mapDistance = mapDistance - playerSpeed;
            monster.setMonsterDistance(monster.getMonsterDistance() - monster.getSpeed());
            System.out.println("\nYour instincts guide you closer to saftey...");
        }
        else if(input.equals("forward") && move.getMoveForward() == false){
            monster.setMonsterDistance(monster.getMonsterDistance() - monster.getSpeed());
            System.out.println("\nYou chose poorly. And the beast grows ever closer...");
        }
        else if(input.equals("backward") && move.getMoveBackward() != false){
            mapDistance = mapDistance - playerSpeed;
            monster.setMonsterDistance(monster.getMonsterDistance() - monster.getSpeed());
            System.out.println("\nYour instincts guide you closer to saftey...");
        }
        else if(input.equals("backward") && move.getMoveBackward() == false){
            monster.setMonsterDistance(monster.getMonsterDistance() - monster.getSpeed());
            System.out.println("\nYou chose poorly. And the beast grows ever closer...");
        }
        else if(input.equals("right") && move.getMoveRight() != false){
            mapDistance = mapDistance - playerSpeed;
            monster.setMonsterDistance(monster.getMonsterDistance() - monster.getSpeed());
            System.out.println("\nYour instincts guide you closer to saftey...");
        }
        else if(input.equals("right") && move.getMoveRight() == false){
            monster.setMonsterDistance(monster.getMonsterDistance() - monster.getSpeed());
            System.out.println("\nYou chose poorly. And the beast grows ever closer...");
        }
        else if(input.equals("left") && move.getMoveLeft() != false){
            mapDistance = mapDistance - playerSpeed;
            monster.setMonsterDistance(monster.getMonsterDistance() - monster.getSpeed());
            System.out.println("\nYour instincts guide you closer to saftey...");
        }
        else if(input.equals("left") && move.getMoveLeft() == false){
            monster.setMonsterDistance(monster.getMonsterDistance() - monster.getSpeed());
            System.out.println("\nYou chose poorly. And the beast grows ever closer...");
        }
        
        
        if(input.equals("weapon") && special.getHasWeapon() == true) {
            special.useWeapon(special);
            mapDistance = mapDistance - playerSpeed;
        }
        else if(input.equals("weapon") && special.getHasWeapon() == false){
            special.useWeapon(special);
        }
        
        if(input.equals("medkit")) {
            special.useMedkit(special);
        }
        
            System.out.println("\nMonster range to player: " + monster.getMonsterDistance());
            System.out.println();

    }
    if(monster.getMonsterDistance() <= 0){
        
        System.out.println("\n" + monster.getName() + ": " +  monster.getKillLine());
    }
    else if(monster.getMonsterDistance() > 0)
        System.out.println("Grats! You have escaped!");
  }

}
