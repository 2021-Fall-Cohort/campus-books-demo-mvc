package wcci.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wcci.demo.model.Author;
import wcci.demo.model.Book;
import wcci.demo.model.Campus;
import wcci.demo.repos.AuthorRepository;
import wcci.demo.repos.BookRepository;
import wcci.demo.repos.CampusRepository;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class CampusController {

    private BookRepository bookRepo;
    private AuthorRepository authorRepo;
    private CampusRepository campusRepo;

    public CampusController(BookRepository bookRepo, AuthorRepository authorRepo, CampusRepository campusRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.campusRepo = campusRepo;
    }

    @RequestMapping("/")
    public String showCampuses(Model model){


        model.addAttribute("campuses",campusRepo.findAll());
        model.addAttribute("authors", authorRepo.findAll());

        return "campuses";
    }
    @RequestMapping("/campuses/{location}")
    public String showCampus(Model model, @PathVariable String location){
        System.out.println(location);
        model.addAttribute("campus",campusRepo.findByLocationIgnoreCase(location));
        return "campus";
    }
}
