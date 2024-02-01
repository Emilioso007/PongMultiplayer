package ScreenClasses.Screens;

import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import ScreenClasses.ScreenObjects.Button.ButtonHandler;
import Utils.KH;
import processing.core.PApplet;

public class MainMenuScreen extends Screen {

    private PApplet p;

    private ButtonHandler buttonHandler;

    public MainMenuScreen() {
        p = ScreenManager.p;

        buttonHandler = new ButtonHandler();

        buttonHandler.addButton("Play as client", 100, 100, 100, 50, () -> {
            ScreenManager.setScreen(new ClientGameScreen());
        });

        buttonHandler.addButton("Play as server", 100, 200, 100, 50, () -> {
            ScreenManager.setScreen(new ServerGameScreen());
        });

    }

    public void update() {

        buttonHandler.update();
    }

    public void render() {
        p.background(42);

        buttonHandler.render();
    }

}
