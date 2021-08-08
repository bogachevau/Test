package homeWork8;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new YandexWeatherModel();
    private Map<Integer, Integer> variants = new HashMap<>();

    public Controller() {
        variants.put(1, 1);
        variants.put(5, 5);
    }

    public void getWeather(String userInput) throws IOException, SQLException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)){
            case 1:
                weatherModel.getWeather(1);
                break;
            case 5:
                weatherModel.getWeather(5);
        }
    }
}
