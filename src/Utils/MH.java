package Utils;

import processing.core.PApplet;

public class MH {

    private static PApplet p;

    public static boolean leftPressed, rightPressed, leftClicked, rightClicked, scrollUp, scrollDown;
    public static int mouseX, mouseY, pmouseX, pmouseY, mouseScroll;

    private static boolean al = false, bl = true, ar = false, br = true;

    private static int lastScroll = -1;

    private MH() {
    }

    public static void initialize(PApplet p) {
        MH.p = p;
    }

    public static void update() {

        bl = !al;
        al = (p.mousePressed && p.mouseButton == PApplet.LEFT);
        leftClicked = (al && bl);

        br = !ar;
        ar = (p.mousePressed && p.mouseButton == PApplet.RIGHT);
        rightClicked = (ar && br);

        leftPressed = p.mousePressed && p.mouseButton == PApplet.LEFT;
        rightPressed = p.mousePressed && p.mouseButton == PApplet.RIGHT;
        pmouseX = p.pmouseX;
        pmouseY = p.pmouseY;
        mouseX = p.mouseX;
        mouseY = p.mouseY;

        if (lastScroll < p.frameCount - 1) {
            scrollUp = false;
            scrollDown = false;
        }

    }

    public static void mouseWheel(int delta, int lastScroll_) {
        if (delta < 0) {
            scrollUp = true;
            scrollDown = false;
        } else if (delta > 0) {
            scrollUp = false;
            scrollDown = true;
        }

        mouseScroll = delta;

        lastScroll = lastScroll_;

    }

}
