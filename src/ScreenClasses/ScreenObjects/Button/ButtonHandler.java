package ScreenClasses.ScreenObjects.Button;

import java.util.ArrayList;

public class ButtonHandler {

    ArrayList<Button> buttons = new ArrayList<Button>();

    public ButtonHandler() {

    }

    public void addButton(Button button) {
        buttons.add(button);
    }

    public void addButton(String text, String key, int x, int y, int w, int h, ButtonAction action) {
        buttons.add(new Button(text, key, x, y, w, h, action));
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

    public Button getButton(String key) {
        for (Button button : buttons) {
            if (button.key.equals(key)) {
                return button;
            }
        }
        return null;
    }

}
