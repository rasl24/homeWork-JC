package lesson7.project;

import java.io.IOException;

public interface WeatherModel {
    //метод, который будет обращаться к апи
    void getWeather(String city, Period period) throws IOException;
}
