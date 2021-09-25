package lesson7.project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    //нужно сделать связь между контроллером и моделью
    private WeatherModel weatherModel = new AccuweatherModel();

    //указать варианты, которые введет пользователь
    private Map<Integer, Period> variants = new HashMap<>();
    public Controller(){
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String userInput, String city) throws IOException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)){
            case NOW:
                weatherModel.getWeather(city, Period.NOW);
            case FIVE_DAYS:
                weatherModel.getWeather(city, Period.FIVE_DAYS);
                break;
        }
    }
}
