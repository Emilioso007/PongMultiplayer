package ScreenClasses.Screens;

import LogicClasses.GameManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;

public class Game extends Screen {

    private PApplet p;

    private GameManager gameManager;

    public Game() {
        p = ScreenManager.p;
        gameManager = new GameManager();

    }

    public void update() {
        gameManager.update();
    }

    public void render() {
        p.background(42);

    }

}
