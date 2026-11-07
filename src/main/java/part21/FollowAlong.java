package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and drives it until it is close to the wall.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "wall-ahead")
public class FollowAlong {
    // Main method where the program starts running.
    public static void main(String[] args) {
        // Creates a new Rover object named scout with the name "Scout".
        Rover scout = new Rover("Scout");
        // Prints a message saying the rover is ready.
        System.out.println(scout + " is ready");
        // Makes the rover drive forward until it detects an object within 20 cm.
        scout.driveUntilBlocked();
        // Prints a message saying the rover has stopped because something is less than 20 cm ahead.
        System.out.println(scout + " stopped. Something is less than 20 cm ahead.");
    }
}