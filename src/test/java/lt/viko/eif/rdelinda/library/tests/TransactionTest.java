package lt.viko.eif.rdelinda.library.tests;

import lt.viko.eif.rdelinda.library.model.Book;
import lt.viko.eif.rdelinda.library.model.Member;
import lt.viko.eif.rdelinda.library.model.Transaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void testTransactionCreation() {
        Book book = new Book("Title", "Author", "123456789");
        Member member = new Member("1", "John Doe");
        Transaction transaction = new Transaction(book, member, "2023-01-01", "2023-01-10");

        assertEquals(book, transaction.getBook());
        assertEquals(member, transaction.getMember());
        assertEquals("2023-01-01", transaction.getBorrowDate());
        assertEquals("2023-01-10", transaction.getReturnDate());
    }

    @Test
    void testSetters() {
        Book book = new Book("Title", "Author", "123456789");
        Member member = new Member("1", "John Doe");
        Transaction transaction = new Transaction(book, member);

        transaction.setBorrowDate("2023-01-01");
        transaction.setReturnDate("2023-01-10");

        assertEquals("2023-01-01", transaction.getBorrowDate());
        assertEquals("2023-01-10", transaction.getReturnDate());
    }
}
