package lt.viko.eif.rdelinda.library.clientside;

import lt.viko.eif.rdelinda.library.model.Book;
import lt.viko.eif.rdelinda.library.model.Member;
import lt.viko.eif.rdelinda.library.model.Transaction;
import lt.viko.eif.rdelinda.library.service.LibraryService;

import java.util.List;

public class LibraryClient {
    private LibraryService libraryService;

    public LibraryClient(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public List<Book> searchBooksByTitle(String title) {
        return libraryService.searchBooksByTitle(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return libraryService.searchBooksByAuthor(author);
    }

    public boolean orderBook(String title, String author, String isbn) {
        return libraryService.orderBook(title, author, isbn);
    }

    public boolean borrowBook(String memberId, String isbn) {
        return libraryService.borrowBook(memberId, isbn);
    }

    public boolean returnBook(String memberId, String isbn) {
        return libraryService.returnBook(memberId, isbn);
    }

    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    public List<Member> getAllMembers() {
        return libraryService.getAllMembers();
    }

    public List<Transaction> getTransactionsByMember(String memberId) {
        return libraryService.getTransactionsByMember(memberId);
    }


}
