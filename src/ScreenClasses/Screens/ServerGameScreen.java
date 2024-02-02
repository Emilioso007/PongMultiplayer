package ScreenClasses.Screens;

import LogicClasses.GameManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import Utils.Font;
import processing.core.PApplet;
import processing.core.PConstants;

public class ServerGameScreen extends Screen {

    private PApplet p;

    private GameManager gameManager;

    public ServerGameScreen() {
        p = ScreenManager.p;
        gameManager = new GameManager(true);

    }

    public void update() {
        gameManager.update();
    }

    public void render() {
        p.background(42);

        //draw game objects
        p.fill(255);
        p.stroke(0);
        p.strokeWeight(1);
        p.circle(gameManager.ball.x, gameManager.ball.y, gameManager.ball.r * 2);
        p.rect(gameManager.paddle1.x, gameManager.paddle1.y, gameManager.paddle1.w, gameManager.paddle1.h);
        p.rect(gameManager.paddle2.x, gameManager.paddle2.y, gameManager.paddle2.w, gameManager.paddle2.h);

        //show scores
        p.fill(255);
        p.textFont(Font.font[32]);
        p.textAlign(PConstants.RIGHT, PConstants.CENTER);
        p.text(gameManager.player1Score, p.width / 2 - 25, 50);
        p.textAlign(PConstants.LEFT, PConstants.CENTER);
        p.text(gameManager.player2Score, p.width / 2 + 25, 50);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.text("|", p.width / 2, 50);

        //show player status (server or client)
        p.fill(255);
        p.textFont(Font.font[32]);
        p.textAlign(PConstants.LEFT, PConstants.TOP);
        p.text("Server Game Screen", 100, 100);
    }

}
