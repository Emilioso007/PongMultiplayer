package ScreenClasses.ScreenObjects.Button;

import java.util.ArrayList;

public class ButtonHandler {

    ArrayList<Button> buttons = new ArrayList<Button>();

    public ButtonHandler() {

    }

    public void addButton(Button button) {
        buttons.add(button);
    }

    public void addButton(String text, int x, int y, int w, int h, ButtonAction action) {
        buttons.add(new Button(text, x, y, w, h, action));
    }

    public void update() {
        for (Button button : buttons) {
            button.update();
        }
    }

    public void render() {
        for (Button button : buttons) {
            button.render();
        }
    }

}
