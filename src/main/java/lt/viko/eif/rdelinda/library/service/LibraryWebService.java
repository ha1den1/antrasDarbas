package lt.viko.eif.rdelinda.library.service;

import jakarta.jws.WebService;
/**
 * Web service interface for the library service.
 */
@WebService
public interface LibraryWebService {
    String getLibraryCatalog();
}
