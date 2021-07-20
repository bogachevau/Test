package homeWork1;

public class Main {
    public static void main(String[] args) {
        Actions[] players = {
                new Cat(5, 2, "Барсик"),
                new Cat(6, 1, "Мурзик"),
                new Human(10, 2, "Анна"),
                new Human(12, 3, "Иван"),
                new Robot(4, 0, "R2D2"),
                new Robot(15, 5, "T800")
        };

        Obstacle[] obstacles = {
                new Treadmill(4),
                new Wall(1),
                new Treadmill(10),
                new Wall(3)
        };

        for (Actions player : players) {
            System.out.println("К прохождению препятствий приступает " + player);
            boolean winner = true;
            for (Obstacle obstacle : obstacles) {
                System.out.println(player + " пытается преодолеть " + obstacle);
                if (obstacle.toRun(player.getRun()) || obstacle.toJump(player.getJump())) {
                    System.out.println("И у него получается");
                } else {
                    winner = false;
                    System.out.println("И он выбывает!");
                    break;
                }
            }
            if (winner) {
                System.out.println(player + " прошел дистанцию!");
            } else {
                System.out.println(player + " проиграл!");
            }
        }

    }
}

