package homeWork8;

import com.fasterxml.jackson.databind.ObjectMapper;
import homeWork8.entity.Weather;
import okhttp3.*;

import java.io.IOException;
import java.sql.SQLException;

public class YandexWeatherModel implements WeatherModel {
    //https://api.weather.yandex.ru/v2/forecast?
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "api.weather.yandex.ru";
    private static final String VERSION = "v2";
    private static final String FORECAST = "forecast";
    private static final String API_KEY_QUERY_PARAM = "X-Yandex-API-Key";
    private static final String API_KEY = "3c4e73c7-ef7e-4367-b238-5c6e2723a089";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(int period) throws IOException, SQLException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(VERSION)
                .addPathSegment(FORECAST)
                //.addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .build();

        switch (period) {
            case 1:
                /* Насколько я понял Геокодер API у Яндекса платный и другие вроде тоже, поэтому координаты города
                захардкожены, да я и так задерживаю сдачу ДЗ
                */
                String coordinatesCity = "{\n" +
                        "    \"lat\": 45.0448,\n" +
                        "    \"lon\": 38.976,\n" +
                        "    \"lang\": ru-RU,\n" +
                        "    \"limit\": " + period + ",\n" +
                        "  }";

                RequestBody requestBody = RequestBody.create(coordinatesCity, MediaType.parse("JSON"));

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .addHeader("Content-Type", "application/json")
                        .addHeader(API_KEY_QUERY_PARAM, API_KEY)
                        .patch(requestBody)
                        .get()
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                //System.out.println(weatherResponse);
                String localDate = objectMapper.readTree(weatherResponse).at("/now_dt").asText();
                String cityName = objectMapper.readTree(weatherResponse).at("/geo_object/locality/name").asText();
                String yesterday = objectMapper.readTree(weatherResponse).at("/yesterday/temp").asText();
                String feelsLike = objectMapper.readTree(weatherResponse).at("/fact/feels_like").asText();
                System.out.println("Погода в городе " + cityName + " на сегодня: " + localDate + " : "
                        + yesterday + " градусов по цельсию" + "\n" + "Ощущается как: "
                        + feelsLike + " градусов по цельсию");
                String condition = objectMapper.readTree(weatherResponse).at("/fact/condition").asText();

                switch (condition) {
                    case "clear":
                        condition = "ясно";
                        break;
                    case "partly-cloudy":
                        condition = "малооблачно";
                        break;
                    case "cloudy":
                        condition = "облачно с прояснениями";
                        break;
                    case "overcast":
                        condition = "пасмурно";
                        break;
                    case "drizzle":
                        condition = "морось";
                        break;
                    case "light-rain":
                        condition = "небольшой дождь";
                        break;
                    case "rain":
                        condition = "дождь";
                        break;
                    case "moderate-rain":
                        condition = "умеренно сильный дождь";
                        break;
                    case "heavy-rain":
                        condition = "сильный дождь";
                        break;
                    case "continuous-heavy-rain":
                        condition = "длительный сильный дождь";
                        break;
                    case "showers":
                        condition = "ливень";
                        break;
                    case "wet-snow":
                        condition = "дождь со снегом";
                        break;
                    case "light-snow":
                        condition = "небольшой снег";
                        break;
                    case "snow":
                        condition = "снег";
                        break;
                    case "snow-showers":
                        condition = "снегопад";
                        break;
                    case "hail":
                        condition = "град";
                        break;
                    case "thunderstorm":
                        condition = "гроза";
                        break;
                    case "thunderstorm-with-rain":
                        condition = "дождь с грозой";
                        break;
                    case "thunderstorm-with-hail":
                        condition = "гроза с градом";
                        break;
                }

                String windSpeed = objectMapper.readTree(weatherResponse).at("/fact/wind_speed").asText();
                String pressureMm = objectMapper.readTree(weatherResponse).at("/fact/pressure_mm").asText();
                System.out.println("Погодное описание: " + condition + "\n" + "Скорость ветра: " + windSpeed
                        + " м/с." + "\n" + "Давление (в мм рт. ст.): " + pressureMm);

                dataBaseRepository.saveWeatherToDataBase(new Weather(cityName, localDate,
                        Double.parseDouble(yesterday), Double.parseDouble(feelsLike), condition,
                        Double.parseDouble(windSpeed), Integer.parseInt(pressureMm)));

                System.out.println(dataBaseRepository.getSavedToDBWeather());
                break;

            case 5:
                String coordinatesCityAndFiveDays = "{\n" +
                        "    \"lat\": 45.0448,\n" +
                        "    \"lon\": 38.976,\n" +
                        "    \"lang\": ru-RU,\n" +
                        "    \"limit\": " + period + ",\n" +
                        "  }";

                RequestBody requestBodyFiveDays = RequestBody.create(coordinatesCityAndFiveDays,
                        MediaType.parse("JSON"));

                Request requestFiveDays = new Request.Builder()
                        .url(httpUrl)
                        .addHeader("Content-Type", "application/json")
                        .addHeader(API_KEY_QUERY_PARAM, API_KEY)
                        .patch(requestBodyFiveDays)
                        .get()
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(requestFiveDays).execute();
                String weatherResponseFiveDays = fiveDayForecastResponse.body().string();
                System.out.println(weatherResponseFiveDays);
                break;
        }
    }
}
