package wcci.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wcci.demo.repos.AuthorRepository;
import wcci.demo.repos.BookRepository;
import wcci.demo.repos.CampusRepository;

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
}
