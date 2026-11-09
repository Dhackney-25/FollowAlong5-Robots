package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–7 (overriding, and polymorphism)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B also changes CarefulBot.java, FlashyBot.java and Mission.java.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "open-room")
public class Stretch {
        public static void main(String[] args) {

            // My guess:
            // I think it will print Flash! Turning left 90.0
            // followed by true.
            // I think c.turnLeft(90) will run Chassis's turnLeft.
            // I think a.straight(10) will run Chassis's straight.

            MBot2 a = new FlashyBot();
            Chassis c = a;
            a.straight(10);
            c.turnLeft(90);
            System.out.println(a == c);

            // I was wrong because c refers to a FlashyBot object.
            // The object determines which overridden method runs.
            // Therefore, FlashyBot's turnLeft runs.

            System.out.println(a);

            // B4:
            // Mission start: MBot2
            // It prints MBot2 because pick 3 creates a regular MBot2.
            // It uses MBot2's toString() method, which returns its name.
        }
    }
