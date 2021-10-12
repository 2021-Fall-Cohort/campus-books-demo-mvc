package wcci.demo.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

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

    public long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}
