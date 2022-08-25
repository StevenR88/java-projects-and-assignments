package ca.bcit.comp2522.assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Book store.
 */
public class BookStore {
    private String bookStoreName;
    private List<Book> bookList;

    /**
     * Constructor for new Book store.
     *
     * @param newBookStoreName the new book store name
     */
    public BookStore(final String newBookStoreName) {
        this.bookStoreName = newBookStoreName;
        this.bookList = new ArrayList<>();
    }

    /**
     * Add course to bookList array.
     *
     * @param newBook the new book
     */
    public void addBook(final Book newBook) {
        this.bookList.add(newBook);
    }

    /**
     * Gets bookList array size.
     *
     * @return the book size
     */
    public int getBookListSize() {
        return this.bookList.size();
    }

    /**
     * Gets book store name.
     *
     * @return the book store name
     */
    public String getBookStoreName() {
        return bookStoreName;
    }

    /**
     * Sets book store name.
     *
     * @param newBookStoreName the new book store name
     */
    public void setBookStoreName(final String newBookStoreName) {
        bookStoreName = newBookStoreName;
    }

    /**
     * Gets a single book by array index.
     * @param bookArrayIndex as an int
     * @return Book at specified array index
     */
    public Book getBook(int bookArrayIndex) {
        return bookList.get(bookArrayIndex);
    }

    /**
     * Gets book list.
     *
     * @return the book list
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * Sets book list.
     *
     * @param newBookList the new book list
     */
    public void setBookList(final List<Book> newBookList) {
        bookList = newBookList;
    }
}
