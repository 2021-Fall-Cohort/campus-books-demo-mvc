package wcci.demo.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

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

    @ManyToMany
    private Collection<Author> authors;

    public Book(String title, String description, String ISBN, Campus campus, Author... author) {
        this.title = title;
        this.description = description;
        this.ISBN = ISBN;
        this.campus = campus;
        this.authors = Arrays.asList(author);
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

    public Collection<Author> getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(title, book.title) && Objects.equals(description, book.description) && Objects.equals(ISBN, book.ISBN) && Objects.equals(campus, book.campus) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, ISBN, campus, authors);
    }
}
