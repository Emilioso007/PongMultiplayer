package ScreenClasses;

import processing.core.*;

public class ScreenManager {

  public static PApplet p;
  public static Screen currentScreen;

  private ScreenManager(PApplet p) {
  }

  public static void initialize(PApplet p) {
    ScreenManager.p = p;
  }

  public static void run() {
    ScreenManager.currentScreen.update();
    ScreenManager.currentScreen.render();
  }

  public static void setScreen(Screen screen) {
    currentScreen = screen;
  }
}
