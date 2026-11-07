package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9 (the line sensor's numbers, and followLine)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B adds a new class, Lapper, at the bottom of this file.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "line-track")
public class Stretch {
    public static void main(String[] args) {

        int[] readings = {6, 12, 3, 0};

        for (int s : readings) {

            if (s == 4 || s == 8 || s == 12) {
                System.out.println(s + ": turn left");

            } else if (s == 1 || s == 2 || s == 3) {
                System.out.println(s + ": turn right");

            } else if (s == 0) {
                System.out.println(s + ": lost it");

            } else {
                System.out.println(s + ": straight");
            }
        }

        Lapper lapper = new Lapper(new Rover("Loop"));
        lapper.laps(2);
    }
}

class Lapper {

    private Rover rover;
    private int done;

    public Lapper(Rover rover) {
        this.rover = rover;
    }

    public void laps(int n) {
        for (int i = 0; i < n; i++) {
            rover.followLine(725);
            done++;
            System.out.println("Lap " + done + " done");
        }
    }
}
/*
Lapper takes a Rover as a parameter so that the person
using Lapper can choose which rover to use and what its
name will be. This makes the class more flexible instead
of creating a new rover inside the constructor.
*/
