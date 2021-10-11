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
    private String description;
    @OneToMany(mappedBy = "campus")
    private Collection<Book> books;

    public Campus(String location, String description) {
        this.location = location;
        this.description = description;
    }

    public Campus() {
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Book> getBooks() {
        return books;
    }
}
