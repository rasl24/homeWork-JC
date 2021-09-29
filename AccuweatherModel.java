package lesson7.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel{

    // адрес апи
    // http://dataservice.accuweather.com/forecasts/v1/daily/1day/
    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5days";
    private static final String API_KEY = "mF35Up1eakqjn51LWpOuGI1LfGJ5chGa";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void getWeather(String city, Period period) throws IOException {
        // проверка периода
        switch (period){
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();
                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();
                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponce = oneDayForecastResponse.body().string();
                System.out.println(weatherResponce);
                break;
            case FIVE_DAYS:
                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();
                Request request1 = new Request.Builder()
                        .url(httpUrl1)
                        .build();
                Response fiveDaysForecastResponse = okHttpClient.newCall(request1).execute();
                String weatherOnFiveDaysResponce = fiveDaysForecastResponse.body().string();
                System.out.println(weatherOnFiveDaysResponce);
                break;
        }
    }

    //метод для поиска города по введенному ключу
    private String detectCityKey(String city) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", city)
                .build();
        Request request = new Request.Builder()
                .url(httpUrl)
                .addHeader("accept", "application/json")
                .build();
        Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
        String responseString = oneDayForecastResponse.body().string();
        System.out.println(responseString);

        // метод извлечения из ответа locationKey
        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();

        return cityKey;
    }
}
