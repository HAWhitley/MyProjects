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
public class MoveEvent extends Event{
    
                private String mMoveText;
    private boolean mCanMoveForward;
    private boolean mCanMoveBackward;
    private boolean mCanMoveLeft;
    private boolean mCanMoveRight;
    
    public MoveEvent(String moveText, boolean f, boolean b, boolean l
            , boolean r) {
        //super(moveText);
        mMoveText = moveText;
        mCanMoveForward = f;
        mCanMoveBackward = b;
        mCanMoveLeft = l;
        mCanMoveRight = r;
    }
    
    public String getMoveText() {
        return mMoveText;
    }
    
    public boolean getMoveForward() {
        return mCanMoveForward;
    }
    
    public boolean getMoveBackward() {
        return mCanMoveBackward;
    }
    
    public boolean getMoveLeft() {
        return mCanMoveLeft;
    }
    
    public boolean getMoveRight() {
        return mCanMoveRight;
    }
    
    public MoveEvent getWhichMoveEvent(int mapNum) {
        
        // Generates a random number between 1-100
        int moveRand = this.generateRand(100);
        
        MoveEvent retMoveEvent;
        
        // Graveyard
        if(mapNum == 1) {
            // Whole section is a spinner to decide which event gets called
            String event0Text = "Your eyes dart frantically around as you run. "
                    + "You contemplate which direction to go. All you see all "
                    + "\naround you is a sea of gravestones. Your path in all "
                    + "directions is unobscured. Which direction will you run?";
            boolean event0Forward = true;
            boolean event0Backward = true;
            boolean event0Left = true;
            boolean event0Right = true;

            String event1Text = "You follow the path until you reach a "
                    + "mausoleum. You bolt through the door, ignoring the "
                    + "\ncreaks and groans around you. You fling the rear door "
                    + "open, and it slams behind you. You turn around and try "
                    + "\nto open the door, but it is locked. You consider your "
                    + "options. You can run in any direction besides behind you"
                    + " \nas the door is firmly locked. Which direction do you "
                    + "run?";
            boolean event1Forward = true;
            boolean event1Backward = false;
            boolean event1Left = true;
            boolean event1Right = true;

            String event2Text = "The path ahead of you is highly forested. You "
                    + "can just make out the waning moon poking between the "
                    + "\ntreetops. The path ahead intersects with another path,"
                    + " but a fallen tree blocks the route to the left. Darned "
                    + "\nbeavers! You can can still run in any other direction."
                    + " Which path will you take?";
            boolean event2Forward = true;
            boolean event2Backward = true;
            boolean event2Left = false;
            boolean event2Right = true;

            String event3Text = "You follow the path until you reach an "
                    + "intersection. In front of you lies a small burial area; "
                    + "\nperhaps for a large family. The path to your right is "
                    + "sparsely populated by trees and shrubs. The path to your"
                    + "\nright is blocked by a large marble statue of a beaver"
                    + " holding a chainsaw. Coincidentally, you hear a power "
                    + "\nsaw crank and know you must leave quickly. Which path "
                    + "will you chose?";
            boolean event3Forward = true;
            boolean event3Backward = true;
            boolean event3Left = true;
            boolean event3Right = false;

            String event4Text = "Ahead, you can see a tall gate blocking the "
                    + "path. Luckily, an intersecting path follows the gate in "
                    + "\nboth directions. Freedom is so close, yet so far away!"
                    + " The beautiful other side of the fence can't be too far "
                    + "\naway... can it? Which direction do you chose to flee?";
            boolean event4Forward = false;
            boolean event4Backward = true;
            boolean event4Left = true;
            boolean event4Right = true;

            String event5Text = "You are winded. You should have attended "
                    + "cross-country practice more often. You stop to catch "
                    + "\nyour breath in an area with many trees on both sides "
                    + "of the path. A deer catches your eye. It flees and you "
                    + "\nshould too. Do you press forward or turn back?";
            boolean event5Forward = true;
            boolean event5Backward = true;
            boolean event5Left = false;
            boolean event5Right = false;

            String event6Text = "You lose the path and run through a heavily "
                    + "wooded area for a time. Concerned, you wonder if you "
                    + "\nwill ever find the path again or if you will wander "
                    + "until you die. Thankfully, you can just catch a glimpse "
                    + "\nof a path ahead. Meets at a ninety degree angle "
                    + "providing paths forward and to the right. Which do you "
                    + "choose?";
            boolean event6Forward = true;
            boolean event6Backward = false;
            boolean event6Left = false;
            boolean event6Right = true;

            String event7Text = "You come to a footbridge that crosses a swamp."
                    + " The bridge eventually finds its way to a four-way "
                    + "\nintersection. You place your hand on a tree to your "
                    + "right and it falls, destroying the path behind you and "
                    + "\nto your right. The tree has clearly been gnawed, most "
                    + "likely by beavers. Both remaining paths quickly leave "
                    + "\nswampy area. Do you take the path forward or the path "
                    + "leading left?";
            boolean event7Forward = true;
            boolean event7Backward = false;
            boolean event7Left = true;
            boolean event7Right = false;

            String event8Text = "The path you travel comes to an end. A sharp "
                    + "ledge overlooks another path below. You jump down and "
                    + "\nwince as your knees buckle. The pain quickly leaves as"
                    + " you remember the task at hand. Escape! You assess the "
                    + "\nsituation. You cannot scale the sheer face behind you,"
                    + " and the path on which you now stand runs only left and "
                    + "\nright. Which way do you run?";
            boolean event8Forward = false;
            boolean event8Backward = false;
            boolean event8Left = true;
            boolean event8Right = true;

            String event9Text = "The path comes to a sharp right turn. The "
                    + "woods surrounding the graves would almsot seem peaceful "
                    + "\nwere it not for the imminent threat chasing you. You "
                    + "weigh your options. You can either turn back and risk "
                    + "\nmeeting the monster, or you can follow the path to the"
                    + " right. Which way will you decide?";
            boolean event9Forward = false;
            boolean event9Backward = true;
            boolean event9Left = false;
            boolean event9Right = true;

            String event10Text = "You come to a large bridge with a "
                    + "ninety-degree left turn. The bridge crosses a rushing "
                    + "\nriver that snakes under the bridge in a manner that "
                    + "rationalizes my choice for the bridge to turn. You run "
                    + "\nout to the turn in the bridge and realize that more "
                    + "and more boards are missing as you continue on. By the "
                    + "\nturn in the bridge, there are quite a few gaps to "
                    + "contend with. The boards are old and rotting, but you "
                    + "\nare almost to the end. Do you continue crossing the "
                    + "bridge by turning to the right or do you turn back?";
            boolean event10Forward = false;
            boolean event10Backward = true;
            boolean event10Left = true;
            boolean event10Right = false;

            String event11Text = "You follow the path to a small clearing. You "
                    + "accidentally step on a particularly grouchy ghost's "
                    + "\ngrave. He erects ghostly blockades behind you and to "
                    + "your right and left. You can't see them, but they're "
                    + "\nthere. The only way forward is forward. Which way will"
                    + " you go? Forward?";
            boolean event11Forward = true;
            boolean event11Backward = false;
            boolean event11Left = false;
            boolean event11Right = false;

            String event12Text = "You approach a dingy, wooden signpost. The "
                    + "only direction not totally weathered by time is Left. "
                    + "\nThe right leads to the exit, while the left leads to"
                    + " more maze, but mother always said to trust a signpost. "
                    + "\nYou may only go left. Which direction do you choose?";
            boolean event12Forward = false;
            boolean event12Backward = false;
            boolean event12Left = true;
            boolean event12Right = false;

            String event13Text = "You approach a tall brick wall. Two more "
                    + "walls emerge on your right and your left. You see a "
                    + "\nmessage on one of them written in blood: 'This ain't "
                    + "it chief'. You feel like you just got yeeted on. You can"
                    + " \nonly go back. Which direction do you choose?";
            boolean event13Forward = false;
            boolean event13Backward = true;
            boolean event13Left = false;
            boolean event13Right = false;

            String event14Text = "As you walk, you notice a disorderly patch of"
                    + " graves to your left. You see arms reach out from the "
                    + "\nsoil. You'd rather not. You can only go right. Which "
                    + "direction do you choose?";
            boolean event14Forward = false;
            boolean event14Backward = false;
            boolean event14Left = false;
            boolean event14Right = true;
            
            // This section takes the variables chosen by the spinner and 
            //instantiates a MoveEvent with those parameters

            if(moveRand >= 1 && moveRand <= 10) {
                MoveEvent moveEvent0 = new MoveEvent(event0Text, event0Forward
                    , event0Backward, event0Left, event0Right);
                retMoveEvent = moveEvent0;
            }
            else if(moveRand >= 11 && moveRand <= 20) {
                MoveEvent moveEvent1 = new MoveEvent(event1Text, event1Forward
                    , event1Backward, event1Left, event1Right);
                retMoveEvent = moveEvent1;
            }
            else if(moveRand >= 21 && moveRand <= 30) {
                MoveEvent moveEvent2 = new MoveEvent(event2Text, event2Forward
                    , event2Backward, event2Left, event2Right);
                retMoveEvent = moveEvent2;
            }
            else if(moveRand >= 31 && moveRand <= 40) {
                MoveEvent moveEvent3 = new MoveEvent(event3Text, event3Forward
                    , event3Backward, event3Left, event3Right);
                retMoveEvent = moveEvent3;
            }
            else if(moveRand >= 41 && moveRand <= 50) {
                MoveEvent moveEvent4 = new MoveEvent(event4Text, event4Forward
                    , event4Backward, event4Left, event4Right);
                retMoveEvent = moveEvent4;
            }
            else if(moveRand >= 51 && moveRand <= 60) {
                MoveEvent moveEvent5 = new MoveEvent(event5Text, event5Forward
                    , event5Backward, event5Left, event5Right);
                retMoveEvent = moveEvent5;
            }
            else if(moveRand >= 61 && moveRand <= 63) {
                MoveEvent moveEvent6 = new MoveEvent(event6Text, event6Forward
                    , event6Backward, event6Left, event6Right);
                retMoveEvent = moveEvent6;
            }
            else if(moveRand >= 64 && moveRand <= 70) {
                MoveEvent moveEvent7 = new MoveEvent(event7Text, event7Forward
                    , event7Backward, event7Left, event7Right);
                retMoveEvent = moveEvent7;
            }
            else if(moveRand >= 71 && moveRand <= 73) {
                MoveEvent moveEvent8 = new MoveEvent(event8Text, event8Forward
                    , event8Backward, event8Left, event8Right);
                retMoveEvent = moveEvent8;
            }
            else if(moveRand >= 74 && moveRand <= 80) {
                MoveEvent moveEvent9 = new MoveEvent(event9Text, event9Forward
                    , event9Backward, event9Left, event9Right);
                retMoveEvent = moveEvent9;
            }
            else if(moveRand >= 81 && moveRand <= 83) {
                MoveEvent moveEvent10 = new MoveEvent(event10Text
                        , event10Forward, event10Backward, event10Left
                        , event10Right);
                retMoveEvent = moveEvent10;
            }
            else if(moveRand >= 84 && moveRand <= 86) {
                MoveEvent moveEvent11 = new MoveEvent(event11Text
                        , event11Forward, event11Backward, event11Left
                        , event11Right);
                retMoveEvent = moveEvent11;
            }
            else if(moveRand >= 87 && moveRand <= 88) {
                MoveEvent moveEvent12 = new MoveEvent(event12Text
                        , event12Forward, event12Backward, event12Left
                        , event12Right);
                retMoveEvent = moveEvent12;
            }
            else if(moveRand >= 89 && moveRand <= 90) {
                MoveEvent moveEvent13 = new MoveEvent(event13Text
                        , event13Forward, event13Backward, event13Left
                        , event13Right);
                retMoveEvent = moveEvent13;
            }
            else if(moveRand >= 91 && moveRand <= 100) {
                MoveEvent moveEvent14 = new MoveEvent(event14Text
                        , event14Forward, event14Backward, event14Left
                        , event14Right);
                retMoveEvent = moveEvent14;
            }
            else {
                MoveEvent defaultMoveEvent = new MoveEvent("Oh no, something "
                        + "has gone horribly wrong", false, false, false
                        , false);
                retMoveEvent = defaultMoveEvent;
            }
        }
        
        // Jungle
        else if(mapNum == 2) {
            // Whole section is a spinner to decide which event gets called
            String event0Text = "You enter an open patch of land. Every "
                    + "direction is open to you. Which direction do you "
                    + "choose?";
            boolean event0Forward = true;
            boolean event0Backward = true;
            boolean event0Left = true;
            boolean event0Right = true;

            String event1Text = "You move past the beach, and the ocean is"
                    + " behind you. You can't run through the water or you will"
                    + "\ndrown. Which direction do you go?";
            boolean event1Forward = true;
            boolean event1Backward = false;
            boolean event1Left = true;
            boolean event1Right = true;

            String event2Text = "You approach a village. On your left you see "
                    + "a bonfire made to cook you. You decide to not be a meal."
                    + "\nWhich way do you go?";
            boolean event2Forward = true;
            boolean event2Backward = true;
            boolean event2Left = false;
            boolean event2Right = true;

            String event3Text = "As you run through the jungle, you look to "
                    + "your right and see that there is a cliff. The drop is "
                    + "\nover 9000 feet high. Which way do you turn?";
            boolean event3Forward = true;
            boolean event3Backward = true;
            boolean event3Left = true;
            boolean event3Right = false;

            String event4Text = "A tree falls directly in front of you. It is"
                    + " too large for you to jump over. Which direction do you"
                    + "\ngo?";
            boolean event4Forward = false;
            boolean event4Backward = true;
            boolean event4Left = true;
            boolean event4Right = true;

            String event5Text = "You enter a cave in which you can see the "
                    + "exit. However, you do not know if it is safe to go "
                    + "\nthrough. There are walls on your left and right. You "
                    + "can only make it going forward or backward. Which way do"
                    + " you go?";
            boolean event5Forward = true;
            boolean event5Backward = true;
            boolean event5Left = false;
            boolean event5Right = false;

            String event6Text = "You fall into quick sand. On your right is a "
                    + "branch to help you out. There is another branch directly"
                    + "\nin front of you. Going backward or left will only make"
                    + "you sink more. Which way do you go?";
            boolean event6Forward = true;
            boolean event6Backward = false;
            boolean event6Left = false;
            boolean event6Right = true;

            String event7Text = "As you run through the jungle, you look behind"
                    + " you and see that a hungry bird is coming to bite off "
                    + "\nyour head. To your right is a swamp filled with "
                    + "alligators. Your best choice is forward or left. Which "
                    + "\ndirection do you go?";
            boolean event7Forward = true;
            boolean event7Backward = false;
            boolean event7Left = true;
            boolean event7Right = false;

            String event8Text = "You find yourself on a ledge. If you move "
                    + "forward, you risk falling to your death. Your back is"
                    + "\nagainst a wall. Which way do you go?";
            boolean event8Forward = false;
            boolean event8Backward = false;
            boolean event8Left = true;
            boolean event8Right = true;

            String event9Text = "You find yourself in a thick patch of trees."
                    + " Directly in front of you is a python. You hate snakes."
                    + "\nTo your left are thorn bushes. Do you want to risk"
                    + "the pain? Which direction do you choose?";
            boolean event9Forward = false;
            boolean event9Backward = true;
            boolean event9Left = false;
            boolean event9Right = true;

            String event10Text = "In the distance you see a swarm of mosquitos"
                    + " coming at your face. On your right, you see something"
                    + "\nmove without knowing what it is. Do you want to risk"
                    + "it? Which way do you go?";
            boolean event10Forward = false;
            boolean event10Backward = true;
            boolean event10Left = true;
            boolean event10Right = false;

            String event11Text = "Amidst the tranquility of the normal jungle"
                    + " ambience, you hear a low rumble. You've read about this"
                    + "\nin your boy scouts handbook: a mutant beaver. By the "
                    + "sound of it, it's right behind you. Going"
                    + "\nforward is the best course of action. Which way do you"
                    + " go?";
            boolean event11Forward = true;
            boolean event11Backward = false;
            boolean event11Left = false;
            boolean event11Right = false;

            String event12Text = "You come across a lovely garden. At least, "
                    + "half of it is lovely. The right half consists of giant "
                    + "\nflesh-eating plants who would love to take a nibble "
                    + "out of you. You decide to wave goodbye to them. Your "
                    + "\nonly option is to go left. Which way do you choose?";
            boolean event12Forward = false;
            boolean event12Backward = false;
            boolean event12Left = true;
            boolean event12Right = false;

            String event13Text = "You approach a chasm. You spit into the "
                    + "chasm. You determine that the sound will echo back to "
                    + "\nyou approximately within the next 40 to 70 years. "
                    + "You've got strong legs, but not that strong. Do you "
                    + "\ndecide not to jump down and just head back?";
            boolean event13Forward = false;
            boolean event13Backward = true;
            boolean event13Left = false;
            boolean event13Right = false;

            String event14Text = "Despite being chased by a cannabilistic tribe"
                    + ", you've got other things on your mind. You're fed up "
                    + "\nwith the fact that you're a fictional video game "
                    + "character that has to listen to some geeky computer "
                    + "\nscience student. You've had enough. You decide to go "
                    + "right against the will of the user. You will only accept"
                    + " an input of 'right'.";
            boolean event14Forward = false;
            boolean event14Backward = false;
            boolean event14Left = false;
            boolean event14Right = true;
            
            // This section takes the variables chosen by the spinner and 
            //instantiates a MoveEvent with those parameters

            if(moveRand >= 1 && moveRand <= 10) {
                MoveEvent moveEvent0 = new MoveEvent(event0Text, event0Forward
                    , event0Backward, event0Left, event0Right);
                retMoveEvent = moveEvent0;
            }
            else if(moveRand >= 11 && moveRand <= 20) {
                MoveEvent moveEvent1 = new MoveEvent(event1Text, event1Forward
                    , event1Backward, event1Left, event1Right);
                retMoveEvent = moveEvent1;
            }
            else if(moveRand >= 21 && moveRand <= 30) {
                MoveEvent moveEvent2 = new MoveEvent(event2Text, event2Forward
                    , event2Backward, event2Left, event2Right);
                retMoveEvent = moveEvent2;
            }
            else if(moveRand >= 31 && moveRand <= 40) {
                MoveEvent moveEvent3 = new MoveEvent(event3Text, event3Forward
                    , event3Backward, event3Left, event3Right);
                retMoveEvent = moveEvent3;
            }
            else if(moveRand >= 41 && moveRand <= 50) {
                MoveEvent moveEvent4 = new MoveEvent(event4Text, event4Forward
                    , event4Backward, event4Left, event4Right);
                retMoveEvent = moveEvent4;
            }
            else if(moveRand >= 51 && moveRand <= 60) {
                MoveEvent moveEvent5 = new MoveEvent(event5Text, event5Forward
                    , event5Backward, event5Left, event5Right);
                retMoveEvent = moveEvent5;
            }
            else if(moveRand >= 61 && moveRand <= 63) {
                MoveEvent moveEvent6 = new MoveEvent(event6Text, event6Forward
                    , event6Backward, event6Left, event6Right);
                retMoveEvent = moveEvent6;
            }
            else if(moveRand >= 64 && moveRand <= 70) {
                MoveEvent moveEvent7 = new MoveEvent(event7Text, event7Forward
                    , event7Backward, event7Left, event7Right);
                retMoveEvent = moveEvent7;
            }
            else if(moveRand >= 71 && moveRand <= 73) {
                MoveEvent moveEvent8 = new MoveEvent(event8Text, event8Forward
                    , event8Backward, event8Left, event8Right);
                retMoveEvent = moveEvent8;
            }
            else if(moveRand >= 74 && moveRand <= 80) {
                MoveEvent moveEvent9 = new MoveEvent(event9Text, event9Forward
                    , event9Backward, event9Left, event9Right);
                retMoveEvent = moveEvent9;
            }
            else if(moveRand >= 81 && moveRand <= 83) {
                MoveEvent moveEvent10 = new MoveEvent(event10Text
                        , event10Forward, event10Backward, event10Left
                        , event10Right);
                retMoveEvent = moveEvent10;
            }
            else if(moveRand >= 84 && moveRand <= 86) {
                MoveEvent moveEvent11 = new MoveEvent(event11Text
                        , event11Forward, event11Backward, event11Left
                        , event11Right);
                retMoveEvent = moveEvent11;
            }
            else if(moveRand >= 87 && moveRand <= 88) {
                MoveEvent moveEvent12 = new MoveEvent(event12Text
                        , event12Forward, event12Backward, event12Left
                        , event12Right);
                retMoveEvent = moveEvent12;
            }
            else if(moveRand >= 89 && moveRand <= 90) {
                MoveEvent moveEvent13 = new MoveEvent(event13Text
                        , event13Forward, event13Backward, event13Left
                        , event13Right);
                retMoveEvent = moveEvent13;
            }
            else if(moveRand >= 91 && moveRand <= 100) {
                MoveEvent moveEvent14 = new MoveEvent(event14Text
                        , event14Forward, event14Backward, event14Left
                        , event14Right);
                retMoveEvent = moveEvent14;
            }
            else {
                MoveEvent defaultMoveEvent = new MoveEvent("Oh no, something "
                        + "has gone horribly wrong", false, false, false
                        , false);
                retMoveEvent = defaultMoveEvent;
            }
        }
        
        // Office
        else if(mapNum == 3) {
            // Whole section is a spinner to decide which event gets called
            String event0Text = "You scan the perimeter. Fortunately, neither "
                    + "Jim nor Dwight have laid out any traps against each "
                    + "\nother. You are free to move in any direction you "
                    + "please. Which direction do you choose?";
            boolean event0Forward = true;
            boolean event0Backward = true;
            boolean event0Left = true;
            boolean event0Right = true;

            String event1Text = "You walk by the women's room. Creed is right "
                    + "behind you, and it looks like he really needs to go. It"
                    + "\nlooks like you can't head back right now. Your options"
                    + " are forward, left, and right. Which way do you go?";
            boolean event1Forward = true;
            boolean event1Backward = false;
            boolean event1Left = true;
            boolean event1Right = true;

            String event2Text = "You approach the conference room. To your "
                    + "left, Andy is attempting to serenade Angela with his "
                    + "\nukelele. Both you and Angela feel very uncomfortable. "
                    + "You decide to not go in their general direction. Your "
                    + "\noptions are forward, backward, and right. Which way do"
                    + " you go?";
            boolean event2Forward = true;
            boolean event2Backward = true;
            boolean event2Left = false;
            boolean event2Right = true;

            String event3Text = "You come across accounting. To your right, "
                    + "Oscar is attempting to explain why the language is "
                    + "\ncalled Spanish, not Mexican. Kevin is nodding his head"
                    + " as though he understands, but his blank visage tells a "
                    + "\ndifferent story. You'd rather not be lectured right "
                    + "now so you decide to leave them be. Your options are "
                    + "\nforward, backward, and left. Which way do you go?";
            boolean event3Forward = true;
            boolean event3Backward = true;
            boolean event3Left = true;
            boolean event3Right = false;

            String event4Text = "You approach the conference room. You try to "
                    + "open the door so you can hide inside, but it appears "
                    + "\nthat Dwight has welded the door shut. 'Classic Dwight'"
                    + " you think to yourself. You then stop thinking to "
                    + "\nyourself because your life is on the line here, come "
                    + "on, get your head in the game. Your options are right, "
                    + "\nleft, and backward. Which way do you go?";
            boolean event4Forward = false;
            boolean event4Backward = true;
            boolean event4Left = true;
            boolean event4Right = true;

            String event5Text = "You enter the kitchen. To your left, you hear"
                    + " creed playing guitar in the women's room. To your "
                    + "\nright, you smell Kevin's creme brulee burning in the "
                    + "toaster oven. You've got to get out of here asap. Your "
                    + "\noptions are forward and backward. Which direction do "
                    + "you choose?";
            boolean event5Forward = true;
            boolean event5Backward = true;
            boolean event5Left = false;
            boolean event5Right = false;

            String event6Text = "Somehow you arrive in the warehouse. The door "
                    + "behind you automatically locks. To your left is the "
                    + "\nbailer, but Darryl says that you are not allowed to "
                    + "touch it. Your options are forward and right. Which "
                    + "\ndirection do you choose?";
            boolean event6Forward = true;
            boolean event6Backward = false;
            boolean event6Left = false;
            boolean event6Right = true;

            String event7Text = "As you traverse the winding halls of the "
                    + "office, Gabe walks up behind you. You try to ignore that"
                    + " \nhe's there. To your right is Toby's desk. Ugh. Your "
                    + "only feasible options are forward and left. You better "
                    + "\nget out of here soon before the urge to smash Toby's "
                    + "face overwhelms you. Which way do you go?";
            boolean event7Forward = true;
            boolean event7Backward = false;
            boolean event7Left = true;
            boolean event7Right = false;

            String event8Text = "You approach the exit. Freedom is within your"
                    + " grasp. Unfortunately, Bob Vance from Vance "
                    + "\nRefrigeration appears right in front of you. Phyllis "
                    + "sees him and goes up to hug him before realizing that "
                    + "\nyou are in her way. They both politely wait for you to"
                    + " leave. Your options are right and left. Which "
                    + "direction do you choose?";
            boolean event8Forward = false;
            boolean event8Backward = false;
            boolean event8Left = true;
            boolean event8Right = true;

            String event9Text = "You approach Stanley's desk hoping to find "
                    + "someone who hates Michael as much as you do. Oh, looks "
                    + "\nlike he's asleep. Also, Toby is to your left. Gross. "
                    + "The only ways out are backward and right. Which "
                    + "\ndirections do you choose?";
            boolean event9Forward = false;
            boolean event9Backward = true;
            boolean event9Left = false;
            boolean event9Right = true;

            String event10Text = "You approach reception. Erin is trying to "
                    + "figure out where to put the pens. The man delivering the"
                    + " \npens is to your right. Erin won't let him leave until"
                    + " she figures out where the pens go. Looks like your only"
                    + " \noptions are backward and left. Which direction do you"
                    + " choose?";
            boolean event10Forward = false;
            boolean event10Backward = true;
            boolean event10Left = true;
            boolean event10Right = false;

            String event11Text = "You enter HR when you hear Ryan's voice "
                    + "behind you. He's trying to sell you on his latest Get "
                    + "\nRich Quick Scam. You ignore him. Which direction do "
                    + "you choose?";
            boolean event11Forward = true;
            boolean event11Backward = false;
            boolean event11Left = false;
            boolean event11Right = false;

            String event12Text = "You near Jim's desk. However, it is not the "
                    + "Jim you once knew. Dwight is currently being dumbfounded"
                    + "\nby Jim's Asian actor friend. The confusion is "
                    + "palpable, and your brain feels jumbled. The only "
                    + "\ndirection you can think of is left. Do you go left?";
            boolean event12Forward = false;
            boolean event12Backward = false;
            boolean event12Left = true;
            boolean event12Right = false;

            String event13Text = "You approach the kitchen when Kevin appears "
                    + "from out of it. He's carrying his world famous chili. "
                    + "\nHe then spills his world famous chili. The chunky brew"
                    + " quickly encompasses you. Your only chance of escape is"
                    + "\ndirectly behind you. Do you go back?";
            boolean event13Forward = false;
            boolean event13Backward = true;
            boolean event13Left = false;
            boolean event13Right = false;

            String event14Text = "You stop to rest at the copier. When you hear"
                    + " a stern 'Where's Michael?' It's Jan directly to your "
                    + "\nleft. Both you and Michael look terrified. You both "
                    + "decide to avoid her. Which way do you go?";
            boolean event14Forward = false;
            boolean event14Backward = false;
            boolean event14Left = false;
            boolean event14Right = true;
            
            // This section takes the variables chosen by the spinner and 
            //instantiates a MoveEvent with those parameters

            if(moveRand >= 1 && moveRand <= 10) {
                MoveEvent moveEvent0 = new MoveEvent(event0Text, event0Forward
                    , event0Backward, event0Left, event0Right);
                retMoveEvent = moveEvent0;
            }
            else if(moveRand >= 11 && moveRand <= 20) {
                MoveEvent moveEvent1 = new MoveEvent(event1Text, event1Forward
                    , event1Backward, event1Left, event1Right);
                retMoveEvent = moveEvent1;
            }
            else if(moveRand >= 21 && moveRand <= 30) {
                MoveEvent moveEvent2 = new MoveEvent(event2Text, event2Forward
                    , event2Backward, event2Left, event2Right);
                retMoveEvent = moveEvent2;
            }
            else if(moveRand >= 31 && moveRand <= 40) {
                MoveEvent moveEvent3 = new MoveEvent(event3Text, event3Forward
                    , event3Backward, event3Left, event3Right);
                retMoveEvent = moveEvent3;
            }
            else if(moveRand >= 41 && moveRand <= 50) {
                MoveEvent moveEvent4 = new MoveEvent(event4Text, event4Forward
                    , event4Backward, event4Left, event4Right);
                retMoveEvent = moveEvent4;
            }
            else if(moveRand >= 51 && moveRand <= 60) {
                MoveEvent moveEvent5 = new MoveEvent(event5Text, event5Forward
                    , event5Backward, event5Left, event5Right);
                retMoveEvent = moveEvent5;
            }
            else if(moveRand >= 61 && moveRand <= 63) {
                MoveEvent moveEvent6 = new MoveEvent(event6Text, event6Forward
                    , event6Backward, event6Left, event6Right);
                retMoveEvent = moveEvent6;
            }
            else if(moveRand >= 64 && moveRand <= 70) {
                MoveEvent moveEvent7 = new MoveEvent(event7Text, event7Forward
                    , event7Backward, event7Left, event7Right);
                retMoveEvent = moveEvent7;
            }
            else if(moveRand >= 71 && moveRand <= 73) {
                MoveEvent moveEvent8 = new MoveEvent(event8Text, event8Forward
                    , event8Backward, event8Left, event8Right);
                retMoveEvent = moveEvent8;
            }
            else if(moveRand >= 74 && moveRand <= 80) {
                MoveEvent moveEvent9 = new MoveEvent(event9Text, event9Forward
                    , event9Backward, event9Left, event9Right);
                retMoveEvent = moveEvent9;
            }
            else if(moveRand >= 81 && moveRand <= 83) {
                MoveEvent moveEvent10 = new MoveEvent(event10Text
                        , event10Forward, event10Backward, event10Left
                        , event10Right);
                retMoveEvent = moveEvent10;
            }
            else if(moveRand >= 84 && moveRand <= 86) {
                MoveEvent moveEvent11 = new MoveEvent(event11Text
                        , event11Forward, event11Backward, event11Left
                        , event11Right);
                retMoveEvent = moveEvent11;
            }
            else if(moveRand >= 87 && moveRand <= 88) {
                MoveEvent moveEvent12 = new MoveEvent(event12Text
                        , event12Forward, event12Backward, event12Left
                        , event12Right);
                retMoveEvent = moveEvent12;
            }
            else if(moveRand >= 89 && moveRand <= 90) {
                MoveEvent moveEvent13 = new MoveEvent(event13Text
                        , event13Forward, event13Backward, event13Left
                        , event13Right);
                retMoveEvent = moveEvent13;
            }
            else if(moveRand >= 91 && moveRand <= 100) {
                MoveEvent moveEvent14 = new MoveEvent(event14Text
                        , event14Forward, event14Backward, event14Left
                        , event14Right);
                retMoveEvent = moveEvent14;
            }
            else {
                MoveEvent defaultMoveEvent = new MoveEvent("Oh no, something "
                        + "has gone horribly wrong", false, false, false
                        , false);
                retMoveEvent = defaultMoveEvent;
            }
        }
        
        else {
            MoveEvent defaultMoveEvent = new MoveEvent("Oh dear, something has "
                    + "gone horribly wrong", false, false, false, false);
            
            retMoveEvent = defaultMoveEvent;
        }
        
        return retMoveEvent;
    }
}
