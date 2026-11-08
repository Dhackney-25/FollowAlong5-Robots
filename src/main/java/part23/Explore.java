package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3, 5 and 6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Scout and sends it through the junctions to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "junctions")
public class Explore {
    // Main method where the program starts running.
    public static void main(String[] args) {

        // Creates a new Scout named Pathfinder.
        Scout scout = new Scout("Pathfinder");

        // Repeats the process three times, once for each leg of the trip.
        for (int leg = 1; leg <= 3; leg++) {

            // Makes the scout drive until it detects an obstacle.
            int moves = scout.driveUntilBlocked();

            // Prints the leg number and how many moves it took.
            System.out.println("Leg " + leg + ": " + moves + " moves");

            // Checks if the scout has more legs to complete.
            if (leg < 3) {

                // Turns the scout toward the most open side.
                scout.turnTowardOpenSide();
            }
        }

        // Prints a message saying Pathfinder reached the goal.
        System.out.println(scout + " reached the goal");
    }
}
