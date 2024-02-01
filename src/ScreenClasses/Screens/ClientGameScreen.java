package ScreenClasses.Screens;

import LogicClasses.GameManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import Utils.Font;
import processing.core.PApplet;
import processing.core.PConstants;

public class ClientGameScreen extends Screen {

    private PApplet p;

    private GameManager gameManager;

    public ClientGameScreen() {
        p = ScreenManager.p;
        gameManager = new GameManager(false);

    }

    public void update() {
        gameManager.update();
    }

    public void render() {
        p.background(42);

        
        p.fill(255);
        p.stroke(0);
        p.strokeWeight(1);
        p.circle(gameManager.ball.x, gameManager.ball.y, gameManager.ball.r * 2);
        p.rect(gameManager.paddle1.x, gameManager.paddle1.y, gameManager.paddle1.w, gameManager.paddle1.h);
        p.rect(gameManager.paddle2.x, gameManager.paddle2.y, gameManager.paddle2.w, gameManager.paddle2.h);

        p.fill(255);
        p.textFont(Font.font[32]);
        p.textAlign(PConstants.RIGHT, PConstants.TOP);
        p.text("Client Game Screen", p.width - 100, 100);

    }

}
