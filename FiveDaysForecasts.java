package homeworksix;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class FiveDaysForecasts {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addEncodedPathSegments("forecasts/v1/daily/5days/295112?apikey=mF35Up1eakqjn51LWpOuGI1LfGJ5chGa")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String response1 = response.body().string();
        System.out.println(response1);

    }
}
