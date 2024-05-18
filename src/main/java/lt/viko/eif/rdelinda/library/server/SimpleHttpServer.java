package lt.viko.eif.rdelinda.library.server;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import lt.viko.eif.rdelinda.library.service.LibraryWebService;
import lt.viko.eif.rdelinda.library.service.LibraryWebServiceImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * A simple HTTP server for handling library web service requests.
 */;

public class SimpleHttpServer {
    private static HttpServer server;

    public static void main(String[] args) throws Exception {
        try {
            int port = 8080;
            server = HttpServer.create(new InetSocketAddress(port), 0);


            server.createContext("/library", new LibraryHandler());


            server.start();
            System.out.println("Server started on port " + port);
        } finally {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (server != null) {
                    server.stop(0);
                    System.out.println("Server stopped");
                }
            }));
        }
    }

    static class LibraryHandler implements HttpHandler {
        private final LibraryWebService libraryWebService = new LibraryWebServiceImpl();

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            exchange.getResponseHeaders().set("Content-Type", "text/plain");


            String response;
            if ("GET".equals(exchange.getRequestMethod())) {

                response = libraryWebService.getLibraryCatalog();
                exchange.sendResponseHeaders(200, response.getBytes().length);
            } else {
                response = "Unsupported HTTP method";
                exchange.sendResponseHeaders(405, response.getBytes().length);
            }


            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
