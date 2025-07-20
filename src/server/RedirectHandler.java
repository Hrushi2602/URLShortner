package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URI;

public class RedirectHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
       URI uri = exchange.getRequestURI();
       String shortCode = uri.getPath().replace("/s/", "");
        String originalUrl = "https://example.com";
        exchange.getResponseHeaders().set("Location", originalUrl);
        exchange.sendResponseHeaders(302, -1);
     }
}
