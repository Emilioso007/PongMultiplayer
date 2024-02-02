package ScreenClasses.ScreenObjects.InputField;

import LogicClasses.Shapes.AABB;
import ScreenClasses.ScreenManager;
import Utils.MH;
import Utils.Keyboard.KH;
import processing.core.PApplet;
import processing.core.PConstants;

public class InputField extends AABB{
    
    private PApplet p;

    public String text, key;
    public boolean isSelected;
    
    public InputField(String key, float x, float y, float w, float h) {
        super(x, y, w, h);
        p = ScreenManager.p;
        this.key = key;
        text = "";
        isSelected = false;
    }
    
    public void update() {
        
        if(isClicked()){
            isSelected = true;
            text = "";
        } else if(MH.leftClicked && !isClicked()){
            isSelected = false;
        }

        if(isSelected){
            text = KH.lastStringTyped;
        }

    }
    
    public void render() {
        
        if(isSelected){
            p.fill(255);
        } else {
            p.fill(200);
        }
        p.stroke(0);
        p.strokeWeight(1);
        p.rect(x, y, w, h);
        
        p.fill(0);
        p.textAlign(PConstants.LEFT, PConstants.CENTER);
        p.text(text, x + 5, y + h / 2);

    }

}
