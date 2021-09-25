package lesson7.project;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    // нужна связка с контроллером
    private Controller controller = new Controller();

    //метод для взаимодействия с пользователем
    public void runInterface(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Введите город: ");
            String city = scanner.nextLine();

            System.out.println("Введите 1 для прогноза на день, 5 для прогноза на 5 дней, 0 для выхода: ");
            String option = scanner.nextLine();

            if(option.equals("0")) break;

            try {
                controller.getWeather(option, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
