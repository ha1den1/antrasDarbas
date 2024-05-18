package lt.viko.eif.rdelinda.library.model;

/**
 * Represents a transaction in the library system, such as borrowing or returning a book.
 */
public class Transaction {
    private Book book;
    private Member member;
    private String borrowDate;
    private String returnDate;

    /**
     * Constructs a new Transaction with the specified book, member, borrow date, and return date.
     *
     * @param book       the book involved in the transaction
     * @param member     the member involved in the transaction
     * @param borrowDate the date the book was borrowed
     * @param returnDate the date the book was returned
     */
    public Transaction(Book book, Member member, String borrowDate, String returnDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Transaction(Book book, Member member) {
        this.book = book;
        this.member = member;
    }



    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
