package lt.viko.eif.rdelinda.library.tests;

import lt.viko.eif.rdelinda.library.model.Book;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookCreation() {
        Book book = new Book("Title", "Author", "123456789");
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("123456789", book.getIsbn());
    }

    @Test
    void testSetters() {
        Book book = new Book("Title", "Author", "123456789");
        book.setTitle("New Title");
        book.setAuthor("New Author");
        book.setIsbn("987654321");
        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
        assertEquals("987654321", book.getIsbn());
    }
}
