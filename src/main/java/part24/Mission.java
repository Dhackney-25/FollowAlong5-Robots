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

        // Prints a message when the mission begins.
        System.out.println("Mission start");

        // Runs the robot's run method.
        bot.run();

        // Prints a message when the mission is finished.
        System.out.println("Mission done");
    }

    // Main method where the program starts.
    public static void main(String[] args) {

        // Chooses which robot will be used.
        int pick = 1;

        // Declares a variable that can hold an MBot2 robot.
        MBot2 bot;

        // Checks if pick is equal to 1.
        if (pick == 1) {

            // Creates a new CarefulBot.
            bot = new CarefulBot();

            // Checks if pick is equal to 2.
        } else if (pick == 2) {

            // Creates a new FlashyBot.
            bot = new FlashyBot();

            // Runs if pick is not 1 or 2.
        } else {

            // Creates a regular MBot2 robot.
            bot = new MBot2();
        }

        // Starts the mission using the selected robot.
        mission(bot);
    }
}