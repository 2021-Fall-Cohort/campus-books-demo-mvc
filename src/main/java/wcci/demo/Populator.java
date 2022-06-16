package wcci.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wcci.demo.model.Book;
import wcci.demo.repos.BookRepository;

@Component
public class Populator implements CommandLineRunner {

    private BookRepository bookRepo;

    public Populator(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("Head First Java","Kathy Sierra","7/1/2022","345235223");
        bookRepo.save(book1);
        Book book2 = new Book("Giving Tree","Liban","1/1/11","q38947238907");
        bookRepo.save(book2);
        Book book3 = new Book("Thorax Second", "Kathy Sierra","7/12/2000","545664");
    }

}
