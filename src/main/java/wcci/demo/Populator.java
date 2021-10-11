package wcci.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wcci.demo.model.Author;
import wcci.demo.model.Book;
import wcci.demo.model.Campus;
import wcci.demo.repos.AuthorRepository;
import wcci.demo.repos.BookRepository;
import wcci.demo.repos.CampusRepository;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class Populator implements CommandLineRunner {

    private BookRepository bookRepo;
    private AuthorRepository authorRepo;
    private CampusRepository campusRepo;

    public Populator(BookRepository bookRepo, AuthorRepository authorRepo, CampusRepository campusRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.campusRepo = campusRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Campus cleveland = new Campus("Cleveland","Home of rock and roll");
        campusRepo.save(cleveland);
        Campus columbus = new Campus("Columbus","Needs a new name");
        campusRepo.save(columbus);

        Author sierra = new Author("Kathy Sierra");
        authorRepo.save(sierra);
        Author uncleBob = new Author("Uncle Bob");
        authorRepo.save(uncleBob);


        Book myBook = new Book("Head First Java", "Learn Java the easy way","12345",cleveland, sierra);
        Book cleanCode = new Book("Clean Code", "how to write clean code","34545",columbus,uncleBob);
        Book dummies = new Book("Java for dummies", "Learn to code like it's the 2000's", "983475",columbus,sierra);
        bookRepo.save(myBook);
        bookRepo.save(cleanCode);
        bookRepo.save(dummies);
    }


//    Campus cleveland = new Campus("Cleveland","Home rock and roll hall of fame");
//    Campus columbus = new Campus("Columbus", "Scary deer by bridge");
//    Author sierra = new Author("Kathy Sierra");
//    Author uncleBob = new Author("Uncle Bob");
//    //Book headFirstJava = new Book("Head First Java","good for learning concepts","555-44155",sierra);
//    //Book cleanCode = new Book("Clean Code", "Learn the process of writing clean code", "867868",uncleBob);
//
//        columbus.addBook(headFirstJava);
//        columbus.addBook(cleanCode);
//
//    Collection<Campus> campuses = new ArrayList<Campus>();
//        campuses.add(cleveland);
//        campuses.add(columbus);
//        campuses.add(columbus);
//        campuses.add(columbus);
//
//    Collection<Author> authors = new ArrayList<Author>();
//        authors.add(sierra);
//        authors.add(uncleBob);
}
