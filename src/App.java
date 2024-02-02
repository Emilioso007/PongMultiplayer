
import ScreenClasses.ScreenManager;
import ScreenClasses.Screens.MainMenuScreen;
import Utils.Font;
import Utils.MH;
import Utils.Keyboard.KH;
import processing.core.*;
import processing.event.MouseEvent;

public class App extends PApplet {

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(800, 600, P2D);
        smooth(8);
    }

    public void setup() {
        KH.initialize();
        MH.initialize(this);
        ScreenManager.initialize(this);
        Font.loadFonts();
        ScreenManager.setScreen(new MainMenuScreen());
        surface.setResizable(false);
    }

    public void draw() {
        MH.update();

        ScreenManager.run();

        showFPS();

        KH.update();

        System.out.println(KH.lastKeyPressed);
    }

    private void showFPS() {
        fill(255);
        textFont(Font.font[16]);
        textAlign(RIGHT, TOP);
        text("FPS: " + nfc(frameRate, 1), width - 5, 0);
    }

    public void keyPressed() {
        KH.setKey(keyCode, 3);
        // System.out.println(keyCode);
    }

    public void keyReleased() {
        KH.setKey(keyCode, 2);
    }

    public void mouseWheel(MouseEvent event) {
        MH.mouseWheel(event.getCount(), frameCount);
    }

}