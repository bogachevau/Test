package homeWork6;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;

public class YandexWeatherRequest {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        String keyYandexApi = "3c4e73c7-ef7e-4367-b238-5c6e2723a089";

        URL httpUrl = new URL("https://api.weather.yandex.ru/v2/forecast?");
        //Через HttpUrl у меня не получилось сделать, не догадался как правильно прописать addPath()

        String coordinatsSity = "{\n" +
                "    \"lat\": 45.0448,\n" +
                "    \"lon\": 38.976,\n" +
                "    \"lang\": ru-RU,\n" +
                "    \"limit\": 5,\n" +
                "  }";

        RequestBody requestBody = RequestBody.create(coordinatsSity, MediaType.parse("JSON"));

        Request requestYandexWeather = new Request.Builder()
                .url(httpUrl)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Yandex-API-Key", keyYandexApi)
                .patch(requestBody)
                .get()
                .build();

        Response responseYandexWeather = okHttpClient.newCall(requestYandexWeather).execute();

        System.out.println(responseYandexWeather.code());
        System.out.println(responseYandexWeather.headers());

        String responseBodyYandexWeather = responseYandexWeather.body().string();


        System.out.println(responseBodyYandexWeather);
    }
}
