package wcci.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campus campus = (Campus) o;
        return id == campus.id && Objects.equals(location, campus.location) && Objects.equals(description, campus.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, description);
    }
}
