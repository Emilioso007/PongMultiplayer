package LogicClasses;

import LogicClasses.Shapes.Circle;

public class Ball extends Circle {

    public Ball(int x, int y, int r) {
        super(x, y, r);
    }

    public void move(float speed, float angle) {
        x += speed * Math.cos(angle);
        y += speed * Math.sin(angle);
    }

}
