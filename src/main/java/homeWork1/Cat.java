package homeWork1;

public class Cat implements Actions {
    public int run;
    public int jump;
    public String name;

    public Cat(int run, int jump, String name) {
        this.run = run;
        this.jump = jump;
        this.name = name;
    }

    @Override
    public void running (){
        System.out.println("Я кот, я бегу!");
    }

    @Override
    public void jumping(){
        System.out.println("Я кот, я прыгаю!");
    }

    @Override
    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    @Override
    public int getJump() {
        return jump;
    }

    public void setJump(int jump) {
        this.jump = jump;
    }

    @Override
    public String toString(){
        return "Кот по кличке " + name;
    }
}
