package wcci.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wcci.demo.repos.AuthorRepository;

@Controller
public class AuthorController {

    private AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @RequestMapping("/authors/{id}")
    private String showAuthor(Model model, @PathVariable long id) {
        model.addAttribute("author", authorRepo.findById(id).get());
        return "author";
    }
}
