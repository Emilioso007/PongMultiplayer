package Utils.Keyboard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class KH {

    private static HashMap<String, Integer> keyMap = new HashMap<>();
    private static HashMap<Integer, String> keyMap2 = new HashMap<>();

    private static int[] keys = new int[1023];

    public static String lastKeyTyped = "";
    public static String lastStringTyped = "";
    public static String lastKeyPressed = "";

    // states:
    // 0 - up
    // 1 - down
    // 2 - released
    // 3 - pressed

    private KH() {
    }

    public static void setKey(int keyID, int state) {
        keys[keyID] = state;

        lastKeyPressed = "";
        if (state == 3) {
            lastKeyPressed = keyMap2.get(keyID);
        }
    }

    public static boolean keyDown(int keyID) {
        return keys[keyID] == 1;
    }

    public static boolean keyDown(String keyName) {
        return keys[keyMap.get(keyName)] == 1;
    }

    public static boolean keyUp(int keyID) {
        return keys[keyID] == 0;
    }

    public static boolean keyUp(String keyName) {
        return keys[keyMap.get(keyName)] == 0;
    }

    public static boolean keyReleased(int keyID) {
        return keys[keyID] == 2;
    }

    public static boolean keyReleased(String keyName) {
        return keys[keyMap.get(keyName)] == 2;
    }

    // The following 6 methods are more or less the same
    public static boolean keyPressed(int keyID) {
        return keys[keyID] == 3;
    }

    public static boolean keyPressed(String keyName) {
        return keys[keyMap.get(keyName)] == 3;
    }

    public static boolean keyTyped(int keyID) {
        return keys[keyID] == 3;
    }

    public static boolean keyTyped(String keyName) {
        return keys[keyMap.get(keyName)] == 3;
    }

    public static boolean keyClicked(int keyID) {
        return keys[keyID] == 3;
    }

    public static boolean keyClicked(String keyName) {
        return keys[keyMap.get(keyName)] == 3;
    }

    public static void initialize() {
        for (int i = 0; i < keys.length; i++) {
            keys[i] = 0;
        }

        String filePath = "data/Resources/keyCodes.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                if (parts.length == 2) {
                    try {
                        String keyName = parts[0].trim();
                        int keyCode = Integer.parseInt(parts[1].trim());

                        keyMap.put(keyName, keyCode);

                    } catch (NumberFormatException e) {
                        System.err.println("Invalid key code: " + parts[1]);
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String keyName : keyMap.keySet()) {
            keyMap2.put(keyMap.get(keyName), keyName);
        }

    }

    public static void update() {

        lastKeyTyped = "";

        // set lastKeyTyped to keyTyped
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == 3) {
                lastKeyTyped = keyMap2.get(i);

            }
        }

        // System.out.println(lastKeyTyped);

        if (lastKeyTyped == null) {
            lastKeyTyped = "";
        } else if (lastKeyTyped.equals("PERIOD")) {
            lastKeyTyped = ".";
        } else if (lastKeyTyped.equals("SPACE")) {
            lastKeyTyped = " ";
        }
        
        if (lastKeyTyped.equals("ENTER")) {
            lastStringTyped = "";
        } else if (lastKeyTyped.equals("BACKSPACE")) {
            if (lastStringTyped.length() > 0) {
                lastStringTyped = lastStringTyped.substring(0, lastStringTyped.length() - 1);
            }
        } else {
            lastStringTyped += lastKeyTyped;
        }

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == 2) {
                keys[i] = 0;
            } else if (keys[i] == 3) {
                keys[i] = 1;
            }
        }
    }

}