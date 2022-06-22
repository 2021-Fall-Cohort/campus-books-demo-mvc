package wcci.demo.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Book{

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String pubDate;
    private String isbn;

    @ManyToOne
    private Campus campus;
    @ManyToMany
    private Collection<Author> authors;

    public Book(String title, String pubDate, String isbn, Campus campus, Author... authors) {
        this.title = title;
        this.pubDate = pubDate;
        this.isbn = isbn;
        this.campus = campus;
        this.authors = Arrays.asList(authors);
    }

    public Book() {
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
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

    public Collection<Author> getAuthors() {
        return authors;
    }
}
