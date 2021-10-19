package wcci.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wcci.demo.model.Author;
import wcci.demo.model.Book;
import wcci.demo.model.Campus;
import wcci.demo.repos.AuthorRepository;
import wcci.demo.repos.BookRepository;
import wcci.demo.repos.CampusRepository;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepo;
    private AuthorRepository authorRepo;
    private CampusRepository campusRepo;

    public BookController(BookRepository bookRepo, AuthorRepository authorRepo, CampusRepository campusRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.campusRepo = campusRepo;
    }

    @RequestMapping("/{id}")
    public String showBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookRepo.findById(id).get());
        return "book";
    }
    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam String description, @RequestParam String ISBN, @RequestParam String author, @RequestParam String location, @RequestParam String imgUrl){
        Campus campus = campusRepo.findByLocationIgnoreCase(location);
        Author author1;
        Optional<Author> authorOpt = authorRepo.findByName(author);
        if(authorOpt.isEmpty()){
            author1 = new Author(author);
            authorRepo.save(author1);
        }
        else{
            author1 = authorOpt.get();
        }
        Book newBook = new Book(title,description,ISBN,campus,imgUrl, author1);
        bookRepo.save(newBook);
        return "redirect:/campuses/" + location;
    }
}
