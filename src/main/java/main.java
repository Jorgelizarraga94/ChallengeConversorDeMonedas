import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que moneda quiere convertir?");
        String moneda = scanner.nextLine();
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/389926c0eaf191d18eeafe8c/latest/"+ moneda;
        System.out.println("A que moneda?");
        String convertirA = scanner.nextLine();

// Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

// Accessing object

        JsonObject req_result = jsonobj.get("conversion_rates").getAsJsonObject();
        int resultado = req_result.get(convertirA).getAsInt();
        System.out.println(resultado);




    }
}
