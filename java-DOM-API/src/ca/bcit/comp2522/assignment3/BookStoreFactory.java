package ca.bcit.comp2522.assignment3;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

// 4. Final proofread

public class BookStoreFactory {
    private static BookStoreFactory bookFactory = null;
    private final BookStore store;

    private BookStoreFactory() {
        this.store = new BookStore("Chapters");
    }

    /**
     * Helper method to build the Course portion of XML file.
     * @param doc as a Document
     * @param courseApplicabilityElement as an Element
     * @param i as an int
     * @return doc as a Document
     */
    public Document buildCourse(final Document doc,
                               final Element courseApplicabilityElement,
                                int i) {
        for (int j = 0; j < this.getStore().getBook(i).
                getCourseApplicabilitySize(); j++) {
            Element courseElement = doc.createElement("course");
            courseApplicabilityElement.appendChild(courseElement);
            courseElement.setAttribute("institute", ""
                    + this.getStore().getBook(i).getCourse(j)
                    .getInstitute());
            courseElement.appendChild(doc.createTextNode(this
                    .getStore().getBook(i).getCourse(j)
                    .getCourseName()));
        }
        return doc;
    }
    /**
     * Helper method to build the Author portion of XML file.
     * @param doc as a Document
     * @param bookElement as an Element
     * @param i as an int
     * @return doc as a Document
     */
    public Document buildAuthor(final Document doc,
                                final Element bookElement,
                                int i) {
        for (int k = 0; k < this.getStore().getBook(i)
                .getAuthorSize(); k++) {
            Element authorElement = doc.createElement("author");
            bookElement.appendChild(authorElement);
            authorElement.setAttribute("firstname", ""
                    + this.getStore().getBook(i).getAuthor(k)
                    .getFirstName());
            authorElement.setAttribute("lastname", ""
                    + this.getStore().getBook(i).getAuthor(k)
                    .getLastName());
        }
        return doc;
    }
    /**
     * Helper method to build the Price portion of XML file.
     * @param doc as a Document
     * @param bookElement as an Element
     * @param i as an int
     * @return doc as a Document
     */
    public Document buildPrice(final Document doc,
                                final Element bookElement,
                                int i) {
        for (int l = 0; l < this.getStore().getBook(i)
                .getPriceSize(); l++) {
            Element priceElement = doc.createElement("price");
            bookElement.appendChild(priceElement);
            priceElement.setAttribute("currency", ""
                    + this.getStore().getBook(i).getPrice(l)
                    .getCurrency());
            priceElement.appendChild(doc.createTextNode(this
                    .getStore().getBook(i).getPrice(l)
                    .getPriceAmount()));
        }
        return doc;
    }
    /**
     * Helper method to build the Stock portion of XML file.
     * @param doc as a Document
     * @param bookElement as an Element
     * @param i as the current counter value for the loop in createXMLDocument
     * @return doc as a Document
     */
    public Document buildStock(final Document doc,
                               final Element bookElement, int i) {
        Element stockElement = doc.createElement("stock");
        bookElement.appendChild(stockElement);
        Element categoryElement = doc.createElement("category");
        stockElement.appendChild(categoryElement);
        categoryElement.appendChild(doc.createTextNode(this
                .getStore().getBook(i).getStock().getCategory()));
        if (!this.getStore().getBook(i).getStock().getSubCategory()
                .equals("")) {
            Element subCategoryElement = doc.createElement("subcategory");
            stockElement.appendChild(subCategoryElement);
            subCategoryElement.appendChild(doc.createTextNode(this
                    .getStore().getBook(i).getStock().getSubCategory()));
        }
        Element copiesInStockElement = doc.createElement("copiesinstock");
        stockElement.appendChild(copiesInStockElement);
        copiesInStockElement.appendChild(doc
                .createTextNode(String.valueOf(this
                        .getStore().getBook(i).getStock().getCopiesInStock())));
        Element coverImageElement = doc.createElement("coverimage");
        stockElement.appendChild(coverImageElement);
        coverImageElement.setAttribute("url", ""
                + this.getStore().getBook(i).getStock().getCoverImage());
        Element availabilityElement = doc.createElement("availability");
        stockElement.appendChild(availabilityElement);
        availabilityElement.setAttribute("days", ""
                + this.getStore().getBook(i).getStock().getAvailability());

        return doc;
    }
    /**
     * Transforms a finished document into XML format.
     * @param doc as a Document object
     * @throws TransformerException as an exception
     */
    public void transformXML(final Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        doc.setXmlStandalone(true);
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("bookStoreA2.xml"));
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(
                "{http://xml.apache.org/xalan}indent-amount", "2");
        transformer.transform(source, result);
    }
    /**
     * Creates an XML document to represent bookStore objects.
     * @throws ParserConfigurationException as an exception
     */
    public void createXMLDocument() throws ParserConfigurationException,
            TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element bookStoreElement = doc.createElement("bookstore");
        doc.appendChild(bookStoreElement);

        Comment comment = doc.createComment(" XML tagset to represent"
                + " book information for the bookstore data set \n  ");
        doc.insertBefore(comment, bookStoreElement);

        for (int i = 0; i < this.getStore().getBookListSize(); i++) {
            Element bookElement = doc.createElement("book");
            bookStoreElement.appendChild(bookElement);
            bookElement.setAttribute("isbn", ""
                    + this.getStore().getBook(i).getIsbn());
            bookElement.setAttribute("year", ""
                    + this.getStore().getBook(i).getYear());
            bookElement.setAttribute("edition", ""
                    + this.getStore().getBook(i).getEdition());

            Element nameElement = doc.createElement("name");
            bookElement.appendChild(nameElement);
            nameElement.appendChild(doc.createTextNode(this
                    .getStore().getBook(i).getName()));

            Element descElement = doc.createElement("description");
            bookElement.appendChild(descElement);
            descElement.appendChild(doc.createTextNode(this
                    .getStore().getBook(i).getDescription()));

            Element courseApplicabilityElement = doc.createElement(
                    "courseapplicability");
            bookElement.appendChild(courseApplicabilityElement);

            doc = buildCourse(doc, courseApplicabilityElement, i);

            doc = buildAuthor(doc, bookElement, i);

            Element pubElement = doc.createElement("publisher");
            bookElement.appendChild(pubElement);
            pubElement.appendChild(doc.createTextNode(this
                    .getStore().getBook(i).getPublisher()));

            doc = buildPrice(doc, bookElement, i);

            doc = buildStock(doc, bookElement, i);

        }
        transformXML(doc);
    }

    /**
     * Checks and instantiates bookFactory if null. Returns current
     * object otherwise.
     * @return bookFactory variable
     */
    public static BookStoreFactory getInstance() {
        if (bookFactory == null) {
            bookFactory = new BookStoreFactory();
        }
        return bookFactory;
    }

    /**
     * Getter for the store variable.
     * @return store variable
     */
    public BookStore getStore() {
        return store;
    }
    /**
     * Drives the program.
     * @param args unused
     * @throws TransformerException as an exception
     * @throws ParserConfigurationException as an exception
     */
    public static void main(final String[] args) throws TransformerException,
            ParserConfigurationException {
        BookStoreFactory bookStoreFactory = BookStoreFactory.getInstance();

        // Adding Book 1
        bookStoreFactory.getStore().addBook(new Book("0321049314",
                2000, 6, "Psychology",
                "Introductory level Pyschology course book",
                "Prentice Hall",
                new Stock("Psychology",
                        10, "./images/psychology-cover.jpg",
                        1)));
        bookStoreFactory.getStore().getBook(0)
                .addCourse(new Course("BCIT", "PSYC1101"));
        bookStoreFactory.getStore().getBook(0)
                .addAuthor(new Author("Carole", "Wade"));
        bookStoreFactory.getStore().getBook(0)
                .addAuthor(new Author("Carol", "Tavris"));
        bookStoreFactory.getStore().getBook(0)
                .addPrice(new Price("CAN", "110.00"));

        // Adding Book 2
        bookStoreFactory.getStore().addBook(new Book("0596001436",
                2001, 1, "Java and XSLT",
                "Embedding XML Processing Into Java Applications",
                "O&Reilly",
                new Stock("Programming", "Java Programming",
                        2, "./images/java-and-xslt-cover.jpg",
                        2)));
        bookStoreFactory.getStore().getBook(1)
                .addCourse(new Course("BCIT", "MMSD4670"));
        bookStoreFactory.getStore().getBook(1)
                .addAuthor(new Author("Eric", "Burke"));
        bookStoreFactory.getStore().getBook(1)
                .addPrice(new Price("CAN", "59.95"));
        bookStoreFactory.getStore().getBook(1)
                .addPrice(new Price("US", "39.95"));

        // Adding Book 3
        bookStoreFactory.getStore().addBook(new Book("0130655678",
                2001, 1, "Definitive XML Schema",
                "XML Schema Reference and Tutorial",
                "Prentice Hall",
                new Stock("Technology", "XML Schema",
                        2, "./images/xml-schema-cover-.jpg",
                        4)));
        bookStoreFactory.getStore().getBook(2)
                .addCourse(new Course("BCIT", "MMSD4670"));
        bookStoreFactory.getStore().getBook(2)
                .addCourse(new Course("BCIT", "MMSD0410"));
        bookStoreFactory.getStore().getBook(2)
                .addCourse(new Course("BCIT", "MMSD4620"));
        bookStoreFactory.getStore().getBook(2)
                .addAuthor(new Author("Priscilla", "Walmsley"));
        bookStoreFactory.getStore().getBook(2)
                .addPrice(new Price("US", "31.49"));

        bookStoreFactory.createXMLDocument();
    }
}

