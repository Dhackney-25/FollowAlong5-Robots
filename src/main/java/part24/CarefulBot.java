package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–3 and 6
//
// Part 24 — overriding: your robot keeps a method's name, but changes what it does.
//
// SECTION A — FOLLOW ALONG: type the CarefulBot class from the guide.
//    Leave the "package part24;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class CarefulBot extends MBot2 {
    // Constructor that creates a new CarefulBot.
    public CarefulBot() {

        // Calls the constructor of the parent MBot2 class.
        super();
    }

    // Overrides the straight method from MBot2.
    @Override
    public void straight(double cm) {

        // Checks if the distance ahead is greater than the requested distance plus 20 cm.
        if (readUltrasonic() > cm + 20) {

            // Moves the robot forward the requested distance.
            super.straight(cm);

            // Runs if there is not enough space to move safely.
        } else {

            // Turns the first LED red to warn that the robot cannot move.
            turnLedOn(1, 255, 0, 0);

            // Prints a message explaining why the robot did not move.
            System.out.println("CarefulBot: not driving " + cm + " cm, too close");
        }
    }

    // Overrides the run method from MBot2.
    @Override
    public void run() {

        // Repeats the movement five times.
        for (int i = 0; i < 5; i++) {

            // Attempts to move forward 40 cm safely.
            straight(40);
        }
    }
}