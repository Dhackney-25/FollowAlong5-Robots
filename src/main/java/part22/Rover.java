package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–9
//
// Part 22 — behaviors: methods that use the sensors to decide what the robot does.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part22;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class Rover {
        // Stores the rover's name.
        private String name;

        // Stores the chassis that controls the rover's movement.
        private Chassis base;

        // Stores the ultrasonic sensor that detects objects ahead.
        private Ultrasonic eyes;

        // Stores the line sensor that detects the line on the ground.
        private LineSensor floor;

        // Remembers which side the line was last detected on.
        private boolean lineWasLeft;

        // Constructor that creates a rover with the given name.
        public Rover(String name) {

            // Sets the rover's name.
            this.name = name;

            // Creates a new chassis for the rover.
            this.base = new Chassis();

            // Connects the ultrasonic sensor to the chassis.
            this.eyes = new Ultrasonic(base);

            // Connects the line sensor to the chassis.
            this.floor = new LineSensor(base);
        }

        // Drives forward until the ultrasonic sensor detects something closer than the given distance.
        public int driveUntilBlocked(double cm) {

            // Starts the movement counter at zero.
            int moves = 0;

            // Keeps moving while the detected distance is greater than cm.
            while (eyes.distance() > cm) {

                // Moves the rover forward 5 cm.
                base.straight(5);

                // Adds one to the number of moves.
                moves++;
            }

            // Returns the total number of moves.
            return moves;
        }

        // Moves the rover around an obstacle on its left side.
        public void goAroundLeft(double sideways) {

            // Turns the rover 90 degrees to the left.
            base.turnLeft(90);

            // Moves the rover sideways by the given distance.
            base.straight(sideways);

            // Turns the rover 90 degrees to the right to face forward again.
            base.turnRight(90);
        }

        // Guides the rover around an obstacle and toward the goal.
        public void reachGoal() {

            // Drives until the rover gets within 15 cm of an obstacle.
            int first = driveUntilBlocked(15);

            // Prints how many moves it took to reach the first obstacle.
            System.out.println("Blocked after " + first + " moves. Going round.");

            // Moves the rover around the obstacle using the left side.
            goAroundLeft(60);

            // Drives forward again until another obstacle is detected.
            int second = driveUntilBlocked(15);

            // Prints how many moves it took to reach the far wall.
            System.out.println("Blocked after " + second + " moves. That is the far wall.");

            // Turns the rover 90 degrees to the right.
            base.turnRight(90);

            // Moves the rover forward 50 cm.
            base.straight(50);
        }

        // Follows the line for the specified number of steps.
        public void followLine(int steps) {

            // Repeats the line-following process for the given number of steps.
            for (int i = 0; i < steps; i++) {

                // Gets the current reading from the line sensor.
                int s = floor.status();

                // Checks if the line is detected on the left side.
                if (s == 4 || s == 8 || s == 12) {

                    // Turns the rover slightly to the left.
                    base.turnLeft(4);

                    // Remembers that the line was last detected on the left.
                    lineWasLeft = true;

                    // Checks if the line is detected on the right side.
                } else if (s == 1 || s == 2 || s == 3) {

                    // Turns the rover slightly to the right.
                    base.turnRight(4);

                    // Remembers that the line was last detected on the right.
                    lineWasLeft = false;

                    // Checks if the sensor does not detect the line.
                } else if (s == 0) {

                    // Checks if the line was last detected on the left.
                    if (lineWasLeft) {

                        // Turns left to try to find the line again.
                        base.turnLeft(4);

                        // Runs if the line was not last detected on the left.
                    } else {

                        // Turns right to try to find the line again.
                        base.turnRight(4);
                    }

                    // Runs if the sensor detects the line in another position.
                } else {

                    // Moves the rover forward 1 cm.
                    base.straight(1);
                }
            }
        }

        // Creates a readable description of the rover.
        public String toString() {

            // Returns the rover's name followed by "the rover".
            return name + " the rover";
        }
    }
