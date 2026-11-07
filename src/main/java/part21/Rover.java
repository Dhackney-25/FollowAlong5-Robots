package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2–8
//
// Part 21 — composition: a Rover HAS-A Chassis and HAS-AN Ultrasonic.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part21;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
//
// SECTION C — STRETCH B adds a LineSensor and two methods to this class.

public class Rover {
    // Stores the rover's name.
    private String name;
    // Stores the rover's chassis (the base that moves).
    private Chassis base;
    // Stores the ultrasonic sensor (the rover's eyes).
    private Ultrasonic eyes;

    // Constructor that creates a rover with the given name.
    public Rover(String name) {
        // Sets the rover's name.
        this.name = name;
        // Creates a new chassis for the rover.
        this.base = new Chassis();
        // Creates an ultrasonic sensor connected to the chassis.
        this.eyes = new Ultrasonic(base);
    }

    // Checks whether an object is closer than the given distance.
    public boolean somethingAhead(double cm) {
        // Returns true if the sensor detects something closer than cm.
        return eyes.distance() < cm;
    }

    // Makes the rover drive forward until something blocks its path.
    public void driveUntilBlocked() {
        // Keeps looping while nothing is detected within 20 centimeters.
        while (!somethingAhead(20)) {
            // Moves the rover forward 5 centimeters.
            base.straight(5);
        }
    }
// Returns a readable description of the rover.
    public String toString() {
        // Combines the rover's name with the words "the rover".
        return name + " the rover";
    }
}