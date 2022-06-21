package wcci.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wcci.demo.model.Book;
import wcci.demo.model.Campus;
import wcci.demo.repos.BookRepository;
import wcci.demo.repos.CampusRepository;

@Component
public class Populator implements CommandLineRunner {

    private BookRepository bookRepo;
    private CampusRepository campusRepo;

    public Populator(BookRepository bookRepo, CampusRepository campusRepo) {
        this.bookRepo = bookRepo;
        this.campusRepo = campusRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Campus columbus = new Campus("Columbus","Java");
        campusRepo.save(columbus);
        Campus cleveland = new Campus("Cleveland","Csharp");
        campusRepo.save(cleveland);

        Book book1 = new Book("Head First Java","Kathy Sierra","7/1/2022","345235223",columbus);
        bookRepo.save(book1);
        Book book2 = new Book("Giving Tree","Liban","1/1/11","q38947238907",columbus);
        bookRepo.save(book2);
        Book book3 = new Book("Thorax Second", "Kathy Sierra","7/12/2000","545664",cleveland);
        bookRepo.save(book3);


    }

}
