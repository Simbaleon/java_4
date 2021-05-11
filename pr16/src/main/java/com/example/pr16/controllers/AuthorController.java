package com.example.pr16.controllers;

import com.example.pr16.dto.AuthorDTO;
import com.example.pr16.models.Author;
import com.example.pr16.services.AuthorService;
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
        model.addAttribute("newAuthor", new AuthorDTO());
        return "authors/index";
    }

    @DeleteMapping("/authors/{id}")
    public String getAll(@PathVariable("id") int id) {
        authorService.delete(id);
        return "redirect:/authors";
    }

    @PostMapping("/authors")
    public String create(@ModelAttribute("newAuthor") AuthorDTO authorDTO) {
        authorService.save(authorDTO);
        return "redirect:/authors";
    }
}
