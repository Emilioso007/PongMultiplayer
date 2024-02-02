package Utils.Keyboard;

public class Key {

    public String name;
    public String value;
    public int code;
    public int state;

    //states:
    // 0 - up
    // 1 - down
    // 2 - just released
    // 3 - just pressed

    public Key() {
        name = "";
        value = "";
        code = 0;
        state = 0;
    }

    public void update(){
        if (state == 3) {
            state = 1;
        } else if (state == 2) {
            state = 0;
        }
    }

    public boolean isDown() {
        return state == 1 || state == 3;
    }

    public boolean isUp() {
        return state == 0 || state == 2;
    }

    public boolean isTyped() {
        return state == 3;
    }

    public boolean isReleased() {
        return state == 2;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
