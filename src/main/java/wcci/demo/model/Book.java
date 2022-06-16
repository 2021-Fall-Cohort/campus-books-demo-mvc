package wcci.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book{

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String author;
    private String pubDate;
    private String isbn;

    public Book(String title, String author, String pubDate, String isbn) {
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.isbn = isbn;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getIsbn() {
        return isbn;
    }
}
