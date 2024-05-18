package lt.viko.eif.rdelinda.library.model;

/**
 * Represents a book in the library system.
 */
public class Book {
    private String title;
    private String author;
    private String isbn;

    /**
     * Constructs a new Book with the specified title, author, and ISBN.
     *
     * @param title  the title of the book
     * @param author the author of the book
     * @param isbn   the ISBN of the book
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
