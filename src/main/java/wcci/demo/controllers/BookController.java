package wcci.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wcci.demo.repos.BookRepository;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepo;


    public BookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @RequestMapping("/{id}")
    public String showBook(Model model, @PathVariable Long id) {
        model.addAttribute("whatEverIwant", bookRepo.findById(id).get());

        return "book";
    }
    @RequestMapping("/")
    public String showAllBooks(Model model){
        model.addAttribute("books",bookRepo.findAll());
        return "allBooks";
    }

}
