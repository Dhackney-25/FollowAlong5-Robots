package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2, 5 and 7
//
// SECTION A — FOLLOW ALONG: type the mission method and the main method from the guide.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "wall-ahead")
public class Mission {
    // Runs a mission using any robot that extends MBot2.
    public static void mission(MBot2 bot) {
            System.out.println("Mission start: " + bot);

            bot.straight(40);
            bot.turnLeft(90);
            bot.straight(40);
            bot.turnRight(90);
            bot.straight(40);
            bot.turnLeft(90);

            System.out.println("Mission done: " + bot);
        }

        public static void main (String[]args){
            int pick = 1;

            if (pick == 1) {
                mission(new CarefulBot());
            } else if (pick == 2) {
                mission(new FlashyBot());
            } else {
                mission(new MBot2());
            }
        }
    }