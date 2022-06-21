package wcci.demo.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
public class Campus {
    @Id
    @GeneratedValue
    private long id;
    private String location;
    private String techStack;
    @OneToMany(mappedBy = "campus")
    private Collection<Book> books;

    public Campus(String location, String techStack) {
        this.location = location;
        this.techStack = techStack;
        this.books = new ArrayList<>();
    }

    public Campus() {
    }

    public String getLocation() {
        return location;
    }

    public String getTechStack() {
        return techStack;
    }

    public Collection<Book> getBooks() {
        return books;
    }
}
