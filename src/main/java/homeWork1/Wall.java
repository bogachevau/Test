package homeWork1;

public class Wall implements Obstacle {
    public int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean toRun(int run) {
        return false;
    }

    @Override
    public boolean toJump(int jump) {
        return (jump >= height);
    }

    @Override
    public String toString(){
        return "Стену высотой " + height + " м";
    }
}
