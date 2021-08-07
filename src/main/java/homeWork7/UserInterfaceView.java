package homeWork7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Введите 1 для получения прогноза погоды на сегодня; "
                    + "Введите 5 для получения прогноза на 5 дней; Введите 0 для выхода: ");

            String command = scanner.nextLine();

            if (command.equals("0")){
                break;
            } else if (command.equals("1") || command.equals("5")){
                try {
                    controller.getWeather(command);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }else {
                System.out.println("Введено неверное значение, введите верное значение: 1, 5 или 0");
                continue;
            }


        }
    }
}
