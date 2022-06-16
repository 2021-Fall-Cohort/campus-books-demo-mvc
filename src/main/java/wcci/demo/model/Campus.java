package wcci.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
@Entity
public class Campus {
    @Id
    @GeneratedValue
    private long id;
    private String location;
    private String techStack;

    //private Collection<Book> books;

    public Campus(String location, String techStack) {
        this.location = location;
        this.techStack = techStack;
    }

    public Campus() {
    }

    public String getLocation() {
        return location;
    }

    public String getTechStack() {
        return techStack;
    }
}
