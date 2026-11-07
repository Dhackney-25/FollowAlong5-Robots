package part22;

import mbot.*;

// Guide: GUIDE.md in this folder (driveUntilBlocked, step 2; a behavior made of behaviors, step 5;
//        followLine and the line sensor's numbers, steps 7–8)
//
// SECTION D — Challenge. Four behaviors. The test in src/test/java/part22/ChallengeTest.java
// checks all four. Change only the lines marked YOUR CODE. The README explains each one.
//
// The test drives this robot in NEW worlds (worlds/part22-maze.json and worlds/part22-track.json),
// not the ones from class. Your code has to use the sensors to work there.

public class Challenge {

    private Chassis base;
    private Ultrasonic eyes;
    private LineSensor floor;
    private boolean lineWasLeft;

    public Challenge() {
        base = new Chassis();
        eyes = new Ultrasonic(base);
        floor = new LineSensor(base);
    }

    public int driveUntilBlocked(double cm) {
        int moves = 0;

        while (eyes.distance() > cm) {
            base.straight(5);
            moves++;
        }

        return moves;
    }

    public void sidestepRight(double cm) {
        base.turnRight(90);
        base.straight(cm);
        base.turnLeft(90);
    }

    public void reachGoal() {
        driveUntilBlocked(15);
        sidestepRight(70);
        driveUntilBlocked(15);
        sidestepRight(70);
        driveUntilBlocked(15);
    }

    public void followLine(int steps) {
        for (int i = 0; i < steps; i++) {
            int s = floor.status();

            if (s == 4 || s == 8 || s == 12) {
                base.turnLeft(4);
                lineWasLeft = true;

            } else if (s == 1 || s == 2 || s == 3) {
                base.turnRight(4);
                lineWasLeft = false;

            } else if (s == 0) {
                if (lineWasLeft) {
                    base.turnLeft(4);
                } else {
                    base.turnRight(4);
                }

            } else {
                base.straight(1);
            }
        }
    }
}