package Utils;

import ScreenClasses.ScreenManager;
import processing.core.PApplet;

public class Color {

    private PApplet p;

    private int r, g, b, a;
    public int c;

    // constructors
    public Color(int r, int g, int b) {
        this.p = ScreenManager.p;

        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;

        this.c = p.color(r, g, b, a);
    }

    public Color(int r, int g, int b, int a) {
        this.p = ScreenManager.p;

        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;

        this.c = p.color(r, g, b, a);
    }

    public Color(int c) {
        this.p = ScreenManager.p;

        this.r = c;
        this.g = c;
        this.b = c;
        this.a = 255;

        this.c = p.color(r, g, b, a);
    }

    public Color() {
        this.p = ScreenManager.p;

        this.r = 0;
        this.g = 0;
        this.b = 0;
        this.a = 255;

        this.c = p.color(r, g, b, a);
    }

    // setters
    public void setR(int r) {
        this.r = r;
        this.c = p.color(r, g, b, a);
    }

    public void setG(int g) {
        this.g = g;
        this.c = p.color(r, g, b, a);
    }

    public void setB(int b) {
        this.b = b;
        this.c = p.color(r, g, b, a);
    }

    public void setA(int a) {
        this.a = a;
        this.c = p.color(r, g, b, a);
    }

    public void set(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;

        this.c = p.color(r, g, b, a);
    }

    public void set(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;

        this.c = p.color(r, g, b, a);
    }

    public void set(int c) {
        this.r = c;
        this.g = c;
        this.b = c;

        this.c = p.color(r, g, b, a);
    }

    public void set(int c, int a) {
        this.r = c;
        this.g = c;
        this.b = c;
        this.a = a;

        this.c = p.color(r, g, b, a);
    }

    // getters
    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    // functions
    public static Color lerp(Color a, Color b, float t) {
        return new Color(
                (int) PApplet.lerp(a.r, b.r, t),
                (int) PApplet.lerp(a.g, b.g, t),
                (int) PApplet.lerp(a.b, b.b, t),
                (int) PApplet.lerp(a.a, b.a, t));
    }

}
