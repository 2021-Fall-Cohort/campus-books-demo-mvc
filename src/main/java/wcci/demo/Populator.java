package wcci.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wcci.demo.model.Author;
import wcci.demo.model.Book;
import wcci.demo.model.Campus;
import wcci.demo.repos.AuthorRepository;
import wcci.demo.repos.BookRepository;
import wcci.demo.repos.CampusRepository;

@Component
public class Populator implements CommandLineRunner {

    private BookRepository bookRepo;
    private CampusRepository campusRepo;
    private AuthorRepository authorRepo;

    public Populator(BookRepository bookRepo, CampusRepository campusRepo, AuthorRepository authorRepo) {
        this.bookRepo = bookRepo;
        this.campusRepo = campusRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Campus columbus = new Campus("Columbus","Java");
        campusRepo.save(columbus);
        Campus cleveland = new Campus("Cleveland","Csharp");
        campusRepo.save(cleveland);

        Author kathy = new Author("Kathy Sierra");
        authorRepo.save(kathy);
        Author david = new Author("David");
        authorRepo.save(david);
        Author liban = new Author("Liban");
        authorRepo.save(liban);

        Book book1 = new Book("Head First Java","7/1/2022","345235223",columbus, kathy, liban);
        bookRepo.save(book1);
        Book book2 = new Book("Giving Tree","1/1/11","q38947238907",columbus, liban, david);
        bookRepo.save(book2);
        Book book3 = new Book("Thorax Second","7/12/2000","545664",cleveland, david);
        bookRepo.save(book3);


    }

}
