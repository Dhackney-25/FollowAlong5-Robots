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

        // Stores the rover's chassis that controls movement.
        private Chassis base;

        // Stores the ultrasonic sensor that detects objects ahead.
        private Ultrasonic eyes;

        // Stores the line sensor that detects tape on the ground.
        private LineSensor floor;

        // Constructor that creates a rover with a name.
        public Rover(String name) {

            // Sets the rover's name.
            this.name = name;

            // Creates a new chassis for the rover.
            this.base = new Chassis();

            // Connects the line sensor to the chassis.
            this.floor = new LineSensor(base);

            // Connects the ultrasonic sensor to the chassis.
            this.eyes = new Ultrasonic(base);
        }

        // Checks if something is closer than the given distance.
        public boolean somethingAhead(double cm) {

            // Returns true if an object is closer than the given distance.
            return eyes.distance() < cm;
        }

        // Makes the rover drive until something blocks its path.
        public void driveUntilBlocked() {

            // Keeps moving while nothing is detected within 20 cm.
            while (!somethingAhead(20)) {

                // Moves the rover forward 5 cm.
                base.straight(5);
            }
        }

        // Makes the rover drive until its line sensor detects tape.
        public void driveToTape() {

            // Keeps moving while the sensor does not see tape.
            while (!floor.seesTape()) {

                // Moves the rover forward 2 cm at a time.
                base.straight(2);
            }
        }

        // Moves the rover forward the requested distance.
        public void forward(double cm) {

            // Tells the chassis to move straight for the given distance.
            base.straight(cm);
        }

        // Creates a readable description of the rover.
        public String toString() {

            // Returns the rover's name followed by "the rover".
            return name + " the rover";
        }
    }
