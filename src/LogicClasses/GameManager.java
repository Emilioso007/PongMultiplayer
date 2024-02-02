package LogicClasses;

import ScreenClasses.ScreenManager;
import Utils.Keyboard.KH;
import processing.core.PApplet;
import processing.net.*;

public class GameManager {

    // networking stuff
    public Server server;
    public Client client;

    private PApplet p;

    public Ball ball;

    public Paddle paddle1;
    public Paddle paddle2;

    public int player1Score;
    public int player2Score;

    public boolean isServer;

    private int ballSpeed = 5;
    private float ballAngle = (float) (Math.PI + Math.PI / 4f - Math.random() * Math.PI / 2f);

    public GameManager(boolean isServer, String ip) {
        this.p = ScreenManager.p;
        this.isServer = isServer;

        if (isServer) {
            server = new Server(p, 8888);
        } else if (!isServer) {
            client = new Client(p, ip, 8888);
        }

        ball = new Ball(p.width / 2, p.height / 2, 10);
        paddle1 = new Paddle(10, p.height / 2 - 50, 20, 100);
        paddle2 = new Paddle(p.width - 30, p.height / 2 - 50, 20, 100);
    }

    public GameManager(boolean isServer) {
        this.p = ScreenManager.p;
        this.isServer = isServer;

        if (isServer) {
            server = new Server(p, 8888);
        }

        ball = new Ball(p.width / 2, p.height / 2, 10);
        paddle1 = new Paddle(10, p.height / 2 - 50, 20, 100);
        paddle2 = new Paddle(p.width - 30, p.height / 2 - 50, 20, 100);
    }

    public void update() {

        if (isServer) {
            // move ball
            for (int i = 0; i < ballSpeed; i++) {
                ball.move(1, ballAngle);
                if (paddle1.intersects(ball)) {
                    ballAngle = (float) (Math.PI / 4f - Math.random() * Math.PI / 2f);
                }
                if (paddle2.intersects(ball)) {
                    ballAngle = (float) (Math.PI + Math.PI / 4f - Math.random() * Math.PI / 2f);
                }

                // bounce ball off walls
                if (ball.y - ball.r < 0 || ball.y + ball.r > p.height) {
                    ballAngle = -ballAngle;
                }

                // check for score
                if (ball.x - ball.r < 0) {
                    player2Score++;
                    ball.x = p.width / 2;
                    ball.y = p.height / 2;
                    ballAngle = (float) (Math.PI + Math.PI / 4f - Math.random() * Math.PI / 2f);
                } else if (ball.x + ball.r > p.width) {
                    player1Score++;
                    ball.x = p.width / 2;
                    ball.y = p.height / 2;
                    ballAngle = (float) (Math.PI + Math.PI / 4f - Math.random() * Math.PI / 2f);
                }

            }

            // get client input and move their paddle
            Client c = server.available();
            if (c != null) {
                String data = c.readStringUntil('\n');
                // System.out.println(data);
                if (data != null) {
                    if (data.equals("W")) {
                        paddle2.y -= 5;
                    } else if (data.equals("S")) {
                        paddle2.y += 5;
                    }
                }
            }

            // move my paddle
            if (KH.keyDown("W")) {
                paddle1.y -= 5;
            } else if (KH.keyDown("S")) {
                paddle1.y += 5;
            }

            // constrain both paddles
            paddle1.y = PApplet.constrain(paddle1.y, 0, p.height - paddle1.h);
            paddle2.y = PApplet.constrain(paddle2.y, 0, p.height - paddle2.h);

            // send data to client
            String stringToClient = paddle1.y + "," + paddle2.y + "," + ball.x + "," + ball.y + "," + player1Score + ","
                    + player2Score + "\n";
            server.write(stringToClient);

        } else if (!isServer) {

            // send input to server
            client.write(KH.lastKeyTyped + "\n");

            // get server data and update gamestate
            String data = client.readStringUntil('\n');
            // System.out.println(data);
            if (data != null) {
                String[] dataSplit = data.split(",");
                paddle1.y = (int) Double.parseDouble(dataSplit[0]);
                paddle2.y = (int) Double.parseDouble(dataSplit[1]);
                ball.x = (int) Double.parseDouble(dataSplit[2]);
                ball.y = (int) Double.parseDouble(dataSplit[3]);
                player1Score = (int) Double.parseDouble(dataSplit[4]);
                player2Score = (int) Double.parseDouble(dataSplit[5]);
            }

        }

    }

}
