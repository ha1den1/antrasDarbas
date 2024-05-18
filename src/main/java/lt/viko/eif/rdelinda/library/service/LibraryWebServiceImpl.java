package lt.viko.eif.rdelinda.library.service;

import jakarta.jws.WebService;
import lt.viko.eif.rdelinda.library.model.Book;
/**
 * Implementation of the library web service.
 */
@WebService(endpointInterface = "lt.viko.eif.rdelinda.library.service.LibraryWebService")
public class LibraryWebServiceImpl implements LibraryWebService {
    private LibraryService libraryService = new LibraryServiceImpl();

    public LibraryWebServiceImpl() {
    }

    @Override
    public String getLibraryCatalog() {
        StringBuilder catalog = new StringBuilder();
        catalog.append("<html><body><h1>Library Catalog</h1><ul>");
        for (Book book : libraryService.getAllBooks()) {
            catalog.append("<li>Title: ").append(book.getTitle())
                    .append(", Author: ").append(book.getAuthor())
                    .append(", ISBN: ").append(book.getIsbn()).append("</li>");
        }
        catalog.append("</ul></body></html>");
        return catalog.toString();
    }
}
