package ScreenClasses.ScreenObjects.Slider;

import LogicClasses.Shapes.AABB;
import ScreenClasses.ScreenManager;
import Utils.MH;
import processing.core.PApplet;
import processing.core.PConstants;

public class Slider extends AABB {

    private PApplet p;

    private int intValue = 0;
    public float value = 0;

    public String text;

    public boolean render = true;

    public Slider(int x, int y, int w, int h, String text, float startValue) {
        super(x, y, w, h);
        this.p = ScreenManager.p;
        this.text = text;
        this.intValue = (int)(startValue * 100);
        this.value = startValue;
    }

    public void update() {
        if (this.contains(MH.mouseX, MH.mouseY)) {
            if (MH.leftPressed) {
                intValue = (int) PApplet.map(MH.mouseX, x + 5, x + w - 5, 0, 100);
            }
        }

        if (this.contains(MH.mouseX, MH.mouseY)) {
            if (MH.scrollUp) {
                intValue += 1;
            }
            if (MH.scrollDown) {
                intValue -= 1;
            }
        }

        if (intValue > 100) {
            intValue = 100;
        } else if (intValue < 0) {
            intValue = 0;
        }

        this.value = this.intValue / 100f;
    }

    public void render() {
        if (render) {
            p.fill(255);
            p.textAlign(PConstants.CENTER, PConstants.CENTER);
            p.textSize(20);
            p.text(text + ": " + value, x + w / 2, y - 20);
            p.fill(255);
            p.rect(x, y, w, h);
            p.fill(0);
            //draw circle at value
            p.ellipse(x + PApplet.map(intValue, 0, 100, 5, w - 5), y + h / 2, 10, 10);
        }
    }

}
