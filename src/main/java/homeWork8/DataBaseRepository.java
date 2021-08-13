package homeWork8;

import homeWork8.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private String insertWeather = "insert into weather (city, localdate, temperature, feels_like, " +
            "condition, wind_speed, pressure_mm) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getTemperature());
            saveWeather.setDouble(4, weather.getFeelsLike());
            saveWeather.setString(5, weather.getCondition());
            saveWeather.setDouble(6, weather.getWindSpeed());
            saveWeather.setInt(7, weather.getPressureMm());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение прогноза погоды в базу данных не выполнено!");
    }

    public List<Weather> getSavedToDBWeather() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weather");
            List<Weather> weatherList = new ArrayList<Weather>();
            while (resultSet.next()){

                weatherList.add(new Weather(resultSet.getString("city"),
                        resultSet.getString("localdate"),
                        resultSet.getDouble("temperature"),
                        resultSet.getDouble("feels_like"),
                        resultSet.getString("condition"),
                        resultSet.getDouble("wind_speed"),
                        resultSet.getInt("pressure_mm")));
            }
            return weatherList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Чтение прогноза погоды из базы данных не выполнено!");
    }
}
