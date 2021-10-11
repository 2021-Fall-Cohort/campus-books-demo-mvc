package wcci.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    private String ISBN;
    @ManyToOne
    private Campus campus;

    @ManyToOne
    private Author author;

    public Book(String title, String description, String ISBN, Campus campus, Author author) {
        this.title = title;
        this.description = description;
        this.ISBN = ISBN;
        this.campus = campus;
        this.author = author;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }
}
