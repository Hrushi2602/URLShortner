import com.sun.net.httpserver.*;
import server.AuthHandler;
import server.RedirectHandler;
import server.ShortenUrlHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import com.sun.net.httpserver.HttpServer;

public class Main {
    public static void main(String[] args) throws IOException {
      //  System.out.println("Hello world!");

       HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
         httpServer.createContext("/shorten", new ShortenUrlHandler());
         httpServer.createContext("/s", new RedirectHandler());
         httpServer.createContext("/auth", new AuthHandler());
         httpServer.setExecutor(Executors.newFixedThreadPool(10));
         httpServer.start();

         System.out.println("Server started on port 8000");

    }
}