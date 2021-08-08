package homeWork8;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherModel {
    void getWeather( int period) throws IOException, SQLException;
}
