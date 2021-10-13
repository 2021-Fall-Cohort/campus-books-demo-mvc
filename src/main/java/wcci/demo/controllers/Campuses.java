package wcci.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class Campuses {

    private BookRepository bookRepo;
    private AuthorRepository authorRepo;
    private CampusRepository campusRepo;

    public Campuses(BookRepository bookRepo, AuthorRepository authorRepo, CampusRepository campusRepo) {
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
}
