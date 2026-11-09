package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4 and 6
//
// SECTION A — FOLLOW ALONG: type the FlashyBot class from the guide.
//    Leave the package, import and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

public class FlashyBot extends MBot2 {
    // Constructor that creates a new FlashyBot.
    public FlashyBot() {

        // Calls the constructor of the parent MBot2 class.
        super();
    }

    // Overrides the turnLeft method from MBot2.
    @Override
    public void turnLeft(double degrees) {

        // Prints a message showing that the robot is turning left.
        System.out.println("Flash! Turning left " + degrees);

        // Turns the first LED blue.
        turnLedOn(1, 0, 0, 255);

        // Makes the robot turn left by the specified degrees.
        super.turnLeft(degrees);

        // Turns off the first LED.
        turnLedOff(1);
    }

    // Overrides the turnRight method from MBot2.
    @Override
    public void turnRight(double degrees) {

        // Prints a message showing that the robot is turning right.
        System.out.println("Flash! Turning right " + degrees);

        // Turns the first LED green.
        turnLedOn(1, 0, 255, 0);

        // Makes the robot turn right by the specified degrees.
        super.turnRight(degrees);

        // Turns off the first LED.
        turnLedOff(1);
    }

    // Overrides the run method from MBot2.
    @Override
    public void run() {

        // Repeats the movement four times.
        for (int i = 0; i < 4; i++) {

            // Moves the robot forward 40 cm.
            straight(40);

            // Turns the robot left 90 degrees.
            turnLeft(90);
        }
    }
}