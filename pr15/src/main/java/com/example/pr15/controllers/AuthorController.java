package com.example.pr15.controllers;

import com.example.pr15.models.Author;
import com.example.pr15.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String getAll(Model model) {
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("newAuthor", new Author());
        return "authors/index";
    }

    @DeleteMapping("/authors/{id}")
    public String getAll(@PathVariable("id") int id) {
        authorService.delete(id);
        return "redirect:/authors";
    }

    @PostMapping("/students")
    public String create(@ModelAttribute("newAuthor") Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }
}
