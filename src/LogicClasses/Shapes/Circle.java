package LogicClasses.Shapes;

public class Circle {

    public float x, y, r;

    public Circle(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public boolean intersects(Circle other) {
        float distance = (float) Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
        if (distance < r + other.r) {
            return true;
        }
        return false;
    }

    public boolean contains(float x, float y) {
        float distance = (float) Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
        if (distance < r) {
            return true;
        }
        return false;
    }

    public boolean intersects(AABB other) {

        float distanceX = Math.abs(x - other.x);
        float distanceY = Math.abs(y - other.y);

        if (distanceX > (other.w / 2 + r)) {
            return false;
        }
        if (distanceY > (other.h / 2 + r)) {
            return false;
        }

        if (distanceX <= (other.w / 2)) {
            return true;
        }
        if (distanceY <= (other.h / 2)) {
            return true;
        }

        float cornerDistance_sq = (float) (Math.pow(distanceX - other.w / 2, 2) + Math.pow(distanceY - other.h / 2, 2));

        return (cornerDistance_sq <= Math.pow(r, 2));

    }

}
