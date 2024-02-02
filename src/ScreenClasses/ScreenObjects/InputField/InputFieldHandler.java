package ScreenClasses.ScreenObjects.InputField;

import java.util.ArrayList;

public class InputFieldHandler {

    ArrayList<InputField> inputFields = new ArrayList<InputField>();

    public InputFieldHandler() {

    }

    public void addInputField(InputField inputField) {
        inputFields.add(inputField);
    }

    public void addInputField(String key, float x, float y, float w, float h){
        inputFields.add(new InputField(key, x, y, w, h));
    }

    public void update() {
        for (InputField inputField : inputFields) {
            inputField.update();
        }
    }

    public void render() {
        for (InputField inputField : inputFields) {
            inputField.render();
        }
    }

    public InputField getInputField(String key) {
        for (InputField inputField : inputFields) {
            if (inputField.key.equals(key)) {
                return inputField;
            }
        }
        return null;
    }
}
