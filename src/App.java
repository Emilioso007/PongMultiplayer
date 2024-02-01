
import ScreenClasses.ScreenManager;
import ScreenClasses.Screens.MainMenu;
import Utils.Font;
import Utils.KH;
import Utils.MH;
import processing.core.*;
import processing.event.MouseEvent;

public class App extends PApplet {

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(1280, 720, P2D);
        smooth(8);
    }

    public void setup() {
        KH.initialize();
        MH.initialize(this);
        ScreenManager.initialize(this);
        Font.loadFonts();
        ScreenManager.setScreen(new MainMenu());
    }

    public void draw() {
        MH.update();

        ScreenManager.run();

        showFPS();

        KH.update();
    }

    private void showFPS() {
        fill(255);
        textFont(Font.font[16]);
        textAlign(RIGHT, TOP);
        text("FPS: " + nfc(frameRate, 1), width - 5, 0);
    }

    public void keyPressed() {
        KH.setKey(keyCode, 3);
    }

    public void keyReleased() {
        KH.setKey(keyCode, 2);
    }

    public void mouseWheel(MouseEvent event) {
        MH.mouseWheel(event.getCount(), frameCount);
    }

}