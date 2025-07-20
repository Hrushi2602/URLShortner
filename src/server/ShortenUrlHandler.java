package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ShortenUrlHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if ("POST".equals(exchange.getRequestMethod())){
            InputStream is = exchange.getRequestBody();

            String body = new String(is.readAllBytes());
            String shortCode = "abc123";
            String response = "http://localhost:8080/s/" + shortCode;
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }else {
            exchange.sendResponseHeaders(405, -1);
        }

    }
}
