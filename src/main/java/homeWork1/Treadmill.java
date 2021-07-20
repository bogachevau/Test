package homeWork1;

public class Treadmill implements Obstacle {
    public int length;

    public Treadmill(int length) {
        this.length = length;
    }


    @Override
    public boolean toRun(int run) {
        return (run >= length);
    }

    @Override
    public boolean toJump(int jump) {
        return false;
    }

    @Override
    public String toString() {
        return "Беговую дорожку длиной " + length + " м";
    }
}
