package lt.viko.eif.rdelinda.library.service;

import lt.viko.eif.rdelinda.library.model.Book;
import lt.viko.eif.rdelinda.library.model.Member;
import lt.viko.eif.rdelinda.library.model.Transaction;

import java.util.List;

/**
 * Interface for the library service.
 */
public interface LibraryService {
    List<Book> getAllBooks();
    List<Member> getAllMembers();
    boolean addBook(Book book);
    boolean removeBook(String isbn);
    boolean registerMember(Member member);
    boolean borrowBook(String memberId, String isbn);
    boolean returnBook(String memberId, String isbn);
    List<Transaction> getTransactionsByMember(String memberId);
    List<Book> searchBooksByTitle(String title); // New method
    List<Book> searchBooksByAuthor(String author); // New method
    boolean orderBook(String title, String author, String isbn); // New method
}
