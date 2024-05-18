package lt.viko.eif.rdelinda.library.service;

import lt.viko.eif.rdelinda.library.model.Book;
import lt.viko.eif.rdelinda.library.model.Member;
import lt.viko.eif.rdelinda.library.model.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the library service.
 */
public class LibraryServiceImpl implements LibraryService {
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;

    public LibraryServiceImpl() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public boolean addBook(Book book) {
        if (books.contains(book)) {
            return false;
        }
        books.add(book);
        return true;
    }

    @Override
    public boolean removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registerMember(Member member) {
        if (members.contains(member)) {
            return false;
        }
        members.add(member);
        return true;
    }

    @Override
    public boolean borrowBook(String memberId, String isbn) {
        Member member = getMemberById(memberId);
        Book book = getBookByIsbn(isbn);
        if (member != null && book != null) {
            transactions.add(new Transaction(book, member));
            return true;
        }
        return false;
    }

    @Override
    public boolean returnBook(String memberId, String isbn) {
        for (Transaction transaction : transactions) {
            if (transaction.getMember().getMemberId().equals(memberId) &&
                    transaction.getBook().getIsbn().equals(isbn)) {
                transactions.remove(transaction);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Transaction> getTransactionsByMember(String memberId) {
        List<Transaction> memberTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getMember().getMemberId().equals(memberId)) {
                memberTransactions.add(transaction);
            }
        }
        return memberTransactions;
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public boolean orderBook(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn);
        return addBook(book);
    }

    private Book getBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    private Member getMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}
