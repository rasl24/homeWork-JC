package lesson7.project;

import lesson7.project.entity.Weather;
import org.sqlite.core.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    //для взаимодествия с базой
    // здесь будут сохраняться прочитанные данные

    //создадим строки для sql запросов
    private String insertWeather = "insert into weather (city, localdate, temperature) values (?, ?, ?)";
    private String getWeather = "select * from weather";

    public static String DB_PATH = "jdbc:sqlite:geekbrains.db";

    //создадим соединение с БД
    // чтобы определенный кусок кода выполнился сразу после запуска приложения
    // можно его заключить статический блок
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //метод сохрания данных с сервиса в БД
    // класс Weather (такой класс называется entity) будет отображать реализацию таблицы weather
    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        //установка связи
        PreparedStatement saveWeather;
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {

            //сохранение погоды в базу
            saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение в базу не поизошло");
    }

    public void saveWeatherToDataBase(List<Weather> weatherList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for(Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setDouble(3, weather.getTemperature());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение в базу не поизошло");
    }

    //метод считывания из базы getSaveToWeather
    public List<Weather> getSavedToDBWeather(){
        // метод будет считывать select
        // собирать из него объекты weather
        // и возвращать список
        List<Weather> weathers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)){
            //реализовать метод получения данных из таблицы погоды
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + " "
                        + resultSet.getString("city") + " "
                        + resultSet.getString("localDate") + " "
                        + resultSet.getString("temperature"));
                weathers.add(new Weather(resultSet.getString("city"),
                        resultSet.getString("localdate"),
                        resultSet.getDouble("temperature")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weathers;
    }
    public static void main(String[] args) throws SQLException {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        System.out.println(dataBaseRepository.getSavedToDBWeather());
    }
}
