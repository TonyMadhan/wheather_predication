import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {

    public static void main(String[] args) {
        String apiKey = "YOUR_API_KEY";
        String city = "New York"; // You can change the city here

        try {
            String weatherData = getWeatherData(apiKey, city);
            System.out.println("Weather in " + city + ":");
            System.out.println(weatherData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getWeatherData(String apiKey, String city) throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }
}

