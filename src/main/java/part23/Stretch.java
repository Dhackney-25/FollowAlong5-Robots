package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–4 (extends, super(), and a sensor field)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B adds a new class, Painter, at the bottom of this file.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "color-zones")
public class Stretch {
    /*
    STRETCH A GUESSES:
    1. super() = MBot2
    2. eye.color() = ColorSensor
    3. turnLedOn(1, 255, 0, 0) = Chassis
    4. straight(5) = Chassis
    5. showColor() = Painter
    */

        public static void main(String[] args) {

            Painter p = new Painter();

            System.out.println(p instanceof Painter);
            System.out.println(p instanceof MBot2);
            System.out.println(p instanceof Chassis);

            p.driveToRed();
        }
    }

    class Painter extends MBot2 {

        private ColorSensor eye;

        Painter() {
            super();
            eye = new ColorSensor(this);
        }

        void showColor() {
            String c = eye.color();

            if (c.equals("red")) {
                turnLedOn(1, 255, 0, 0);

            } else if (c.equals("green")) {
                turnLedOn(1, 0, 255, 0);

            } else if (c.equals("blue")) {
                turnLedOn(1, 0, 0, 255);

            } else if (c.equals("yellow")) {
                turnLedOn(1, 255, 200, 0);

            } else {
                turnLedOff(1);
            }
        }

        void driveToRed() {
            String last = "";

            while (!eye.color().equals("red")) {
                String c = eye.color();

                if (!c.equals(last)) {
                    System.out.println("Now on " + c);
                    last = c;
                }

                showColor();
                straight(5);
            }

            showColor();
            System.out.println("Stopped on red");
        }
    }

/*
B3:
The guesses are correct:
super() runs MBot2's constructor.
eye.color() runs ColorSensor's code.
turnLedOn() runs Chassis's code.
straight() runs Chassis's code.
showColor() runs Painter's own code.

B4:
The Scout and Painter have different fields because they
perform different jobs. The Scout uses a Scanner to detect
things, while the Painter uses a ColorSensor to detect
colors. Each robot needs a different sensor for its job.
*/

