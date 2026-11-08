package part23;

import mbot.*;

// Guide: GUIDE.md in this folder (extends and super(), steps 1–2; a scan is an array, step 4)
//
// SECTION D — Challenge. A robot class of your own: an explorer that IS AN MBot2 and
// also carries a Scanner. The test in src/test/java/part23/ChallengeTest.java checks it.
// Change only the lines marked YOUR CODE. The README explains each one.
//
// The test drives this robot in NEW worlds (worlds/part23-maze.json and
// worlds/part23-maze-mirror.json), not the one from class.

public class Challenge extends MBot2 {

    private Scanner scanner;

    // Builds the MBot2 first, then connects the scanner.
    public Challenge() {
        super();
        scanner = new Scanner(this);
    }

    // Drives forward until an object is within 20 cm.
    public int driveUntilBlocked() {
        int moves = 0;

        while (readUltrasonic() > 20) {
            straight(5);
            moves++;
        }

        return moves;
    }

    // Scans once and returns the index with the greatest distance.
    public int openestIndex() {
        double[] distances = scanner.scan();

        int bestIndex = 0;

        for (int i = 1; i < 7; i++) {
            if (distances[i] > distances[bestIndex]) {
                bestIndex = i;
            }
        }

        return bestIndex;
    }

    // Scans once and counts how many distances are greater than cm.
    public int countOpen(double cm) {
        double[] distances = scanner.scan();

        int count = 0;

        for (int i = 0; i < 7; i++) {
            if (distances[i] > cm) {
                count++;
            }
        }

        return count;
    }

    // Turns the robot toward the direction of the selected scanner index.
    public void turnToward(int index) {
        int angle = Scanner.ANGLES[index];

        if (angle > 0) {
            turnLeft(angle);
        } else if (angle < 0) {
            turnRight(-angle);
        }
    }

    // Explores the maze until it reaches a dead end or completes 10 attempts.
    public void explore() {
        for (int i = 0; i < 10; i++) {
            driveUntilBlocked();

            if (countOpen(60) == 0) {
                return;
            }

            turnToward(openestIndex());
        }
    }
}