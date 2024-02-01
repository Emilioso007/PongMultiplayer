package LogicClasses;

import ScreenClasses.ScreenManager;
import Utils.KH;
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
    private float ballAngle = 0;

    public GameManager(boolean isServer) {
        this.p = ScreenManager.p;
        this.isServer = isServer;

        if (isServer) {
            server = new Server(p, 8888);
        } else if (!isServer) {
            client = new Client(p, "INSERT IP HERE", 8888);
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
                    ballAngle = PApplet.PI - ballAngle;
                }
                if (paddle2.intersects(ball)) {
                    ballAngle = PApplet.PI - ballAngle;
                }
            }

            // get client input
            Client c = server.available();

            if (c != null) {
                String data = c.readString();
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

            // send data to client
            String stringToClient = paddle1.y + "," + paddle2.y + "," + ball.x + "," + ball.y;
            server.write(stringToClient);

        } else if (!isServer) {
            ball.x -= ballSpeed * PApplet.cos(ballAngle);
            ball.y -= ballSpeed * PApplet.sin(ballAngle);

            if (KH.keyDown("W")) {
                client.write("W");
            } else if (KH.keyDown("S")) {
                client.write("S");
            } else {
                client.write("N");
            }

            String data = client.readString();
            if (data != null) {
                String[] dataSplit = data.split(",");
                paddle1.y = Integer.parseInt(dataSplit[0]);
                paddle2.y = Integer.parseInt(dataSplit[1]);
                ball.x = Integer.parseInt(dataSplit[2]);
                ball.y = Integer.parseInt(dataSplit[3]);
            }

        }

    }

}
