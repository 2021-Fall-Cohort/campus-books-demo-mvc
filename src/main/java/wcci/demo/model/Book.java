package wcci.demo.model;

import javax.persistence.*;

@Entity
public class Book{

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String author;
    private String pubDate;
    private String isbn;

    @ManyToOne
    private Campus campus;

    public Book(String title, String author, String pubDate, String isbn, Campus campus) {
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.isbn = isbn;
        this.campus = campus;
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

    public Campus getCampus() {
        return campus;
    }
}
