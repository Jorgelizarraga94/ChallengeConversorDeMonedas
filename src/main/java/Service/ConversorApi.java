package Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConversorApi {

    public Double conversion(String cambioDe, String cambioA) throws IOException {
        String url_str = "https://v6.exchangerate-api.com/v6/389926c0eaf191d18eeafe8c/latest/"+ cambioDe;
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
        Double resultado = req_result.get(cambioA).getAsDouble();
        return resultado;
    };

}
