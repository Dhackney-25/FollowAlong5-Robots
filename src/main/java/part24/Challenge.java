package part24;

import mbot.*;

// Guide: GUIDE.md in this folder (override and super.straight, steps 1–3;
//        polymorphism, steps 5–7)
//
// SECTION D — Challenge. A robot that never bumps into anything, and a method that works
// for ANY robot. The test in src/test/java/part24/ChallengeTest.java checks them.
// Change only the lines marked YOUR CODE. The README explains each one.
//
// The test drives this robot in NEW worlds (worlds/part24-hall.json and
// worlds/part24-yard.json), not the one from class.

public class Challenge extends MBot2 {

    public Challenge() {
        super();
    }

    @Override
    public void straight(double cm) {
        if (cm <= 0) {
            super.straight(cm);
            return;
        }

        double left = cm;

        while (left > 0 && readUltrasonic() > 20) {
            double step = Math.min(5, left);
            super.straight(step);
            left -= step;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            straight(1000);
            turnRight(90);
        }
    }

    public static int stepsToWall(MBot2 bot) {
        int count = 0;

        while (bot.readUltrasonic() > 20) {
            bot.straight(10);
            count++;
        }

        return count;
    }
}