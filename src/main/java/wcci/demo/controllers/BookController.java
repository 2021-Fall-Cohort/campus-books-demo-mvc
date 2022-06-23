package wcci.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wcci.demo.model.Author;
import wcci.demo.model.Book;
import wcci.demo.repos.AuthorRepository;
import wcci.demo.repos.BookRepository;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepo;
    private AuthorRepository authorRepo;


    public BookController(BookRepository bookRepo, AuthorRepository authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
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
    @PostMapping("/{id}/addAuthor")
    public String addAuthorToBook(@PathVariable Long id, @RequestParam String author){
        Book book = bookRepo.findById(id).get();
        Optional<Author> authorOptional = authorRepo.findByNameIgnoreCase(author);
        if(authorOptional.isPresent()){
            if(!book.getAuthors().contains(authorOptional.get())){
                book.addAuthor(authorOptional.get());
            }
        }
        else{
            Author author1 = new Author(author);
            authorRepo.save(author1);
            book.addAuthor(author1);
        }
        bookRepo.save(book);

        return "redirect:/books/"+id;


    }
}
