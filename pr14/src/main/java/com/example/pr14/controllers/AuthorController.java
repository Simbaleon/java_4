package com.example.pr14.controllers;

import com.example.pr14.dao.AuthorDAO;
import com.example.pr14.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorController {
    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorController(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @GetMapping("/authors")
    public String getAll(Model model) {
        model.addAttribute("authors", authorDAO.getAll());
        model.addAttribute("newAuthor", new Author());
        return "authors/index";
    }

    @DeleteMapping("/authors/{id}")
    public String getAll(@PathVariable("id") int id) {
        authorDAO.delete(id);
        return "redirect:/authors";
    }

    @PostMapping("/authors")
    public String create(@ModelAttribute("newAuthor") Author author) {
        authorDAO.save(author);
        return "redirect:/authors";
    }
}
