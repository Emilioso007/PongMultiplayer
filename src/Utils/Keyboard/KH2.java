package Utils.Keyboard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KH2 {
    
private static ArrayList<Key> keysArray = new ArrayList<>();

    private KH2() {
    }

    public static void initialize(){

        String path = "data/Resources/keyCodes.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                Key key = new Key();
                key.setName(tokens[0]);
                key.setCode(Integer.parseInt(tokens[1]));
                addKey(key);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void update() {
        for (Key key : keysArray) {
            key.update();
        }
    }

    public static void setKey(int keyCode, int state) {
        for (Key key : keysArray) {
            if (key.code == keyCode) {
                key.setState(state);
            }
        }
    }

    // keyDown with keyCode
    public static boolean keyDown(int keyCode) {
        for (Key key : keysArray) {
            if (key.code == keyCode) {
                return key.isDown();
            }
        }
        return false;
    }

    // keyUp with keyCode
    public static boolean keyUp(int keyCode) {
        for (Key key : keysArray) {
            if (key.code == keyCode) {
                return key.isUp();
            }
        }
        return false;
    }

    // keyTyped with keyCode
    public static boolean keyTyped(int keyCode) {
        for (Key key : keysArray) {
            if (key.code == keyCode) {
                return key.isTyped();
            }
        }
        return false;
    }

    // keyReleased with keyCode
    public static boolean keyReleased(int keyCode) {
        for (Key key : keysArray) {
            if (key.code == keyCode) {
                return key.isReleased();
            }
        }
        return false;
    }

    // 
    public static String getKey(int keyCode) {
        for (Key key : keysArray) {
            if (key.code == keyCode) {
                return key.name;
            }
        }
        return "";
    }

    public static int getKeyCode(String keyName) {
        for (Key key : keysArray) {
            if (key.name.equals(keyName)) {
                return key.code;
            }
        }
        return -1;
    }

    public static boolean keyUp(String keyName) {
        for (Key key : keysArray) {
            if (key.name.equals(keyName)) {
                return key.isUp();
            }
        }
        return false;
    }

    public static boolean keyDown(String keyName) {
        for (Key key : keysArray) {
            if (key.name.equals(keyName)) {
                return key.isDown();
            }
        }
        return false;
    }

    public static boolean keyTyped(String keyName) {
        for (Key key : keysArray) {
            if (key.name.equals(keyName)) {
                return key.isTyped();
            }
        }
        return false;
    }

    public static boolean keyReleased(String keyName) {
        for (Key key : keysArray) {
            if (key.name.equals(keyName)) {
                return key.isReleased();
            }
        }
        return false;
    }

    public static boolean keyPressed(int keyCode) {
        for (Key key : keysArray) {
            if (key.code == keyCode) {
                return key.isTyped();
            }
        }
        return false;
    }

    public static boolean keyPressed(String keyName) {
        for (Key key : keysArray) {
            if (key.name.equals(keyName)) {
                return key.isTyped();
            }
        }
        return false;
    }

    public static boolean keyClicked(int keyCode) {
        for (Key key : keysArray) {
            if (key.code == keyCode) {
                return key.isTyped();
            }
        }
        return false;
    }

    public static boolean keyClicked(String keyName) {
        for (Key key : keysArray) {
            if (key.name.equals(keyName)) {
                return key.isTyped();
            }
        }
        return false;
    }



    private static void addKey(Key key) {
        keysArray.add(key);
    }

}
