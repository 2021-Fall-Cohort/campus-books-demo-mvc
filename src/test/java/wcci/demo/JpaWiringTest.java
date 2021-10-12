package wcci.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import wcci.demo.model.Author;
import wcci.demo.model.Book;
import wcci.demo.model.Campus;
import wcci.demo.repos.AuthorRepository;
import wcci.demo.repos.BookRepository;
import wcci.demo.repos.CampusRepository;

import javax.annotation.Resource;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Resource
    private AuthorRepository authorRepo;
    @Resource
    private BookRepository bookRepo;
    @Resource
    private CampusRepository campusRepo;

    @Test
    public void authorShouldHaveMultipleBooks() {
        Author author1 = new Author("George RR Martin");
        authorRepo.save(author1);

        Campus campus1 = new Campus("Columbus", "The coolest campus");
        campusRepo.save(campus1);

        Book neverComingOut = new Book("Winds of Winter", "Not coming out", "12345678", campus1, author1);
        Book alreadyOut = new Book("A Game of Thrones", "Already out", "9876543", campus1, author1);
        bookRepo.save(neverComingOut);
        bookRepo.save(alreadyOut);

        entityManager.flush();
        entityManager.clear();

        Optional<Author> returnAuthor = authorRepo.findById(author1.getId());
        Author tempAuthor;
        if (returnAuthor.isPresent()) {
            tempAuthor = returnAuthor.get();
        }
        else {
            tempAuthor = null;
        }

        assertThat(tempAuthor.getBooks()).contains(neverComingOut, alreadyOut);
    }

    @Test
    public void authorShouldHaveSpecificBook() {
        Author author1 = new Author("George RR Martin");
        authorRepo.save(author1);

        Campus campus1 = new Campus("Columbus", "The coolest campus");
        campusRepo.save(campus1);

        Book neverComingOut = new Book("Winds of Winter", "Not coming out", "12345678", campus1, author1);
        Book alreadyOut = new Book("A Game of Thrones", "Already out", "9876543", campus1, author1);
        bookRepo.save(neverComingOut);
        bookRepo.save(alreadyOut);

        entityManager.flush();
        entityManager.clear();

        Book windsOfWinter = bookRepo.findByTitle("Winds of Winter");

        assertEquals(windsOfWinter, neverComingOut);
    }
}
