package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–5
//
// Part 23 — inheritance: your own robot class, built on top of MBot2.
//
// SECTION A — FOLLOW ALONG: type the Scout class from the guide.
//    Step 1 changes the class line below: that is the one line you DO change.
//    Leave the "package part23;" line and the "import mbot.*;" line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class Scout extends MBot2 {
    // Stores the scout's name.
    private String name;

    // Creates a Scanner object to measure distances in different directions.
    private Scanner scanner;

    // Constructor that creates a Scout with the given name.
    public Scout(String name) {

        // Calls the constructor of the parent class MBot2.
        super();

        // Sets the scout's name.
        this.name = name;

        // Creates a Scanner attached to this Scout.
        this.scanner = new Scanner(this);
    }

    // Drives forward until the robot detects an obstacle.
    public int driveUntilBlocked() {

        // Keeps track of how many moves the scout makes.
        int moves = 0;

        // Continues driving while the distance is greater than 25.
        while (readUltrasonic() > 25) {

            // Moves the scout forward 5 units.
            straight(5);

            // Adds one to the number of moves.
            moves++;
        }

        // Returns the total number of moves made.
        return moves;
    }

    // Finds the direction with the greatest open distance.
    public int openestIndex() {

        // Scans all directions and stores the distances in an array.
        double[] d = scanner.scan();

        // Assumes the first direction has the greatest distance.
        int best = 0;

        // Checks the remaining directions in the array.
        for (int i = 1; i < d.length; i++) {

            // Checks if the current direction is more open than the best one.
            if (d[i] > d[best]) {

                // Updates best to the index of the more open direction.
                best = i;
            }
        }

        // Returns the index of the most open direction.
        return best;
    }

    // Turns the scout toward the most open side.
    public void turnTowardOpenSide() {

        // Finds the index of the most open direction.
        int i = openestIndex();

        // Checks if the scanner angle is positive, meaning the direction is to the left.
        if (Scanner.ANGLES[i] > 0) {

            // Turns the scout 90 degrees to the left.
            turnLeft(90);

            // Runs if the scanner angle is zero or negative.
        } else {

            // Turns the scout 90 degrees to the right.
            turnRight(90);
        }
    }

    // Returns the scout's name as a String.
    public String toString() {

        // Returns the name followed by "the scout".
        return name + " the scout";
    }
}