package PLWSBMerito;
/*import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
public class Weather {
    public static void main(String[] args) throws Exception {
        String url = "https://api.weatherapi.com/v1/current.json?key=a60a9cb53e274f7bb23104734251005&q=Warsaw";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        WeatherResponse weather = gson.fromJson(response.body(), WeatherResponse.class);

        System.out.println("City: " + weather.location.name);
        System.out.println("Temperature: " + weather.current.temp_c + "°C");
        System.out.println("Weather: " + weather.current.condition.text);
    }
    static class WeatherResponse {
        Location location;
        Current current;
    }

    static class Location {
        String name;
    }

    static class Current {
        float temp_c;
        Condition condition;
    }

    static class Condition {
        String text;
    }
}*/
