package ca.bcit.comp2522.assignment3;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String isbn;
    private int year;
    private int edition;
    private String name;
    private String description;
    private List<Course> courseApplicability;
    private List<Author> author;
    private String publisher;
    private List<Price> price;
    private Stock stock;

    /**
     * Constructor for new Book.
     *
     * @param newIsbn                the new isbn
     * @param newYear                the new year
     * @param newEdition             the new edition
     * @param newName                the new name
     * @param newDescription         the new description
     * @param newPublisher           the new publisher
     * @param newStock               the new stock
     */
    public Book(final String newIsbn, final int newYear, final int newEdition,
                final String newName, final String newDescription,
                final String newPublisher, final Stock newStock) {
        isbn = newIsbn;
        year = newYear;
        edition = newEdition;
        name = newName;
        description = newDescription;
        courseApplicability = new ArrayList<>();
        author = new ArrayList<>();
        publisher = newPublisher;
        price = new ArrayList<>();
        stock = newStock;
    }

    /**
     * Adds a new Course object to courseApplicability array.
     * @param newCourse as a Course object
     */
    public void addCourse(final Course newCourse) {
        this.courseApplicability.add(newCourse);
    }

    /**
     * Gets the size of courseApplicability array.
     * @return size of courseApplicability array
     */
    public int getCourseApplicabilitySize() {
        return this.courseApplicability.size();
    }

    /**
     * Gets a single course by array index.
     * @param courseArrayIndex as an int
     * @return Book at specified array index
     */
    public Course getCourse(int courseArrayIndex) {
        return courseApplicability.get(courseArrayIndex);
    }

    /**
     * Adds a new Author object to author array.
     * @param newAuthor as a Author object
     */
   public void addAuthor(final Author newAuthor) {
        this.author.add(newAuthor);
   }

    /**
     * Gets the size of author array.
     * @return size of author array
     */
    public int getAuthorSize() {
        return this.author.size();
    }

    /**
     * Gets a single Author by array index.
     * @param authorArrayIndex as an int
     * @return Book at specified array index
     */
    public Author getAuthor(int authorArrayIndex) {
        return author.get(authorArrayIndex);
    }

    /**
     * Adds a new Price object to price array.
     * @param newPrice as a Price object
     */
    public void addPrice(final Price newPrice) {
        this.price.add(newPrice);
    }

    /**
     * Gets the size of author array.
     * @return size of author array
     */
    public int getPriceSize() {
        return this.price.size();
    }

    /**
     * Gets a single price by array index.
     * @param priceArrayIndex as an int
     * @return Book at specified array index
     */
    public Price getPrice(int priceArrayIndex) {
        return price.get(priceArrayIndex);
    }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets isbn.
     *
     * @param newIsbn the new isbn
     */
    public void setIsbn(final String newIsbn) {
        isbn = newIsbn;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param newYear the new year
     */
    public void setYear(final int newYear) {
        year = newYear;
    }

    /**
     * Gets edition.
     *
     * @return the edition
     */
    public int getEdition() {
        return edition;
    }

    /**
     * Sets edition.
     *
     * @param newEdition the new edition
     */
    public void setEdition(final int newEdition) {
        edition = newEdition;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param newName the new name
     */
    public void setName(final String newName) {
        name = newName;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param newDescription the new description
     */
    public void setDescription(final String newDescription) {
        description = newDescription;
    }

    /**
     * Gets course applicability.
     *
     * @return the course applicability
     */
    public List<Course> getCourseApplicability() {
        return courseApplicability;
    }

    /**
     * Sets course applicability.
     *
     * @param newCourseApplicability the new course applicability
     */
    public void setCourseApplicability(final List<Course> newCourseApplicability) {
        courseApplicability = newCourseApplicability;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public List<Author> getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param newAuthor the new author
     */
    public void setAuthor(final List<Author> newAuthor) {
        author = newAuthor;
    }

    /**
     * Gets publisher.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets publisher.
     *
     * @param newPublisher the new publisher
     */
    public void setPublisher(final String newPublisher) {
        publisher = newPublisher;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public List<Price> getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param newPrice the new price
     */
    public void setPrice(final List<Price> newPrice) {
        price = newPrice;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param newStock the new stock
     */
    public void setStock(final Stock newStock) {
        stock = newStock;
    }
}
