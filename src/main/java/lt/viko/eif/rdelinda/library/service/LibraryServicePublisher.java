package lt.viko.eif.rdelinda.library.service;

import jakarta.xml.ws.Endpoint;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Publisher class for the library web service.
 */
public class LibraryServicePublisher {
    private static final Logger logger = Logger.getLogger(LibraryServicePublisher.class.getName());
    private static Endpoint endpoint;

    public static void main(String[] args) {
        int port = 8083;

        try {
            String serviceURL = "http://localhost:" + port + "/library";
            logger.log(Level.INFO, "Publishing Library Web Service at " + serviceURL);
            endpoint = Endpoint.publish(serviceURL, new LibraryWebServiceImpl());
            logger.log(Level.INFO, "Library Web Service is published and running at " + serviceURL);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error while publishing the web service", e);
            if (endpoint != null) {
                endpoint.stop();
            }
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (endpoint != null) {
                endpoint.stop();
                logger.log(Level.INFO, "Web service stopped");
            }
        }));
    }
}
