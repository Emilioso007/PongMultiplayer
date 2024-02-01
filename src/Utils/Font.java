package Utils;

import ScreenClasses.ScreenManager;
import processing.core.PFont;

public class Font {
    
    public static final String FONT = "data/Fonts/InconsolataSCBlack.TTF";

    public static PFont[] font = new PFont[128];

    public static void loadFonts() {
        font[0] = null;
        for (int i = 1; i < font.length; i++) {
            font[i] = ScreenManager.p.createFont(FONT, i);
        }
    }

}