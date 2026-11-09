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
    private int refused;

    public CarefulBot() {
        super();
    }

    @Override
    public void straight(double cm) {
        if (readUltrasonic() > cm) {
            super.straight(cm);
        } else {
            refused++;
            System.out.println("CarefulBot: not driving " + cm + " cm, too close");
        }
    }

    @Override
    public String toString() {
        return "CarefulBot (refused " + refused + " moves)";
    }
}