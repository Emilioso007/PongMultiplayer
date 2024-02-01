package ScreenClasses.ScreenObjects.Slider;

import java.util.ArrayList;

public class SliderHandler {

    ArrayList<Slider> sliders = new ArrayList<Slider>();

    public SliderHandler() {

    }

    public void addSlider(Slider slider) {
        sliders.add(slider);
    }

    public void update() {
        for (Slider slider : sliders) {
            slider.update();
        }
    }

    public void render() {
        for (Slider slider : sliders) {
            slider.render();
        }
    }

}
