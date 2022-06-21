package wcci.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wcci.demo.repos.BookRepository;
import wcci.demo.repos.CampusRepository;

@Controller
public class CampusController {
    private CampusRepository campusRepo;
    private BookRepository bookRepository;

    public CampusController(CampusRepository campusRepo, BookRepository bookRepository) {
        this.campusRepo = campusRepo;
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/")
    public String showAllCampuses(Model model){
        model.addAttribute("campuses",campusRepo.findAll());
        return "campuses";
    }
    @RequestMapping("/techStack/{stackName}")
    public String showCampusesByTechStack(Model model, @PathVariable String stackName){
        model.addAttribute("campuses",campusRepo.findByTechStackIgnoreCase(stackName));
        return "campuses";
    }
}
