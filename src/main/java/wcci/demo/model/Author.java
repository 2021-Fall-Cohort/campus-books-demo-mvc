package wcci.demo.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "author")
    private Collection<Book> books;

    public Author(String name, Book... authorBooks) {
        this.name = name;
        this.books = Arrays.asList(authorBooks);
    }

    public Author() {
    }

    public void addBook(Book book){
        books.add(book);
    }

    public String getName() {
        return name;
    }

    public Collection<Book> getBooks() {
        return books;
    }
}
