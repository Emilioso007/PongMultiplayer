package ScreenClasses.Screens;

import java.net.InetAddress;

import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import ScreenClasses.ScreenObjects.Button.ButtonHandler;
import ScreenClasses.ScreenObjects.InputField.InputFieldHandler;
import processing.core.PApplet;

public class MainMenuScreen extends Screen {

    private PApplet p;

    private ButtonHandler buttonHandler;

    private InputFieldHandler inputFieldHandler;

    private String ip, myIp = "not found";

    private boolean showMyIp = false;

    public MainMenuScreen() {
        p = ScreenManager.p;

        try {
            // Get the local host address
            InetAddress localhost = InetAddress.getLocalHost();

            // Get the IP address as a string
            myIp = localhost.getHostAddress();

        } catch (Exception e) {
        }

        buttonHandler = new ButtonHandler();

        buttonHandler.addButton("Play as client", "startClient", 100, 100, 100, 50, () -> {
            ScreenManager.setScreen(new ClientGameScreen(ip));
        });

        buttonHandler.addButton("Play as server", "startServer", 100, 200, 100, 50, () -> {
            ScreenManager.setScreen(new ServerGameScreen());
        });

        //reveal myIp
        buttonHandler.addButton("Show my ip", "showIp", 100, 400, 100, 50, () -> {
            showMyIp = !showMyIp;
            if (showMyIp) {
                buttonHandler.getButton("showIp").text = "My IP: " + myIp;
            } else {
                buttonHandler.getButton("showIp").text = "Show my ip";
            }
        });

        inputFieldHandler = new InputFieldHandler();

        inputFieldHandler.addInputField("IP", 100, 300, 100, 50);

    }

    public void update() {

        buttonHandler.update();
        inputFieldHandler.update();

        ip = inputFieldHandler.getInputField("IP").text;
    }

    public void render() {
        p.background(42);

        buttonHandler.render();
        inputFieldHandler.render();
    }

}
