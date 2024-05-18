package lt.viko.eif.rdelinda.library.tests;

import lt.viko.eif.rdelinda.library.model.Book;
import lt.viko.eif.rdelinda.library.model.Member;
import lt.viko.eif.rdelinda.library.model.Transaction;
import lt.viko.eif.rdelinda.library.service.LibraryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {

    private LibraryServiceImpl libraryService;

    @BeforeEach
    void setUp() {
        libraryService = new LibraryServiceImpl();
    }

    @Test
    void testAddBook() {
        Book book = new Book("Title", "Author", "123456789");
        assertTrue(libraryService.addBook(book));
        assertFalse(libraryService.addBook(book)); // Adding the same book again should return false
    }

    @Test
    void testRemoveBook() {
        Book book = new Book("Title", "Author", "123456789");
        libraryService.addBook(book);
        assertTrue(libraryService.removeBook("123456789"));
        assertFalse(libraryService.removeBook("123456789")); // Removing a non-existent book should return false
    }

    @Test
    void testRegisterMember() {
        Member member = new Member("1", "John Doe");
        assertTrue(libraryService.registerMember(member));
        assertFalse(libraryService.registerMember(member)); // Registering the same member again should return false
    }

    @Test
    void testBorrowAndReturnBook() {
        Book book = new Book("Title", "Author", "123456789");
        Member member = new Member("1", "John Doe");
        libraryService.addBook(book);
        libraryService.registerMember(member);

        assertTrue(libraryService.borrowBook("1", "123456789"));
        assertFalse(libraryService.borrowBook("1", "123456789")); // Borrowing the same book again should return false
        assertTrue(libraryService.returnBook("1", "123456789"));
        assertFalse(libraryService.returnBook("1", "123456789")); // Returning a non-existent transaction should return false
    }

    @Test
    void testGetTransactionsByMember() {
        Book book = new Book("Title", "Author", "123456789");
        Member member = new Member("1", "John Doe");
        libraryService.addBook(book);
        libraryService.registerMember(member);
        libraryService.borrowBook("1", "123456789");

        List<Transaction> transactions = libraryService.getTransactionsByMember("1");
        assertEquals(1, transactions.size());
        assertEquals("1", transactions.get(0).getMember().getMemberId());
        assertEquals("123456789", transactions.get(0).getBook().getIsbn());
    }
}
