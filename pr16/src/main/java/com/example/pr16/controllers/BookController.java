package com.example.pr16.controllers;

import com.example.pr16.models.Book;
import com.example.pr16.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private final BookService universityService;

    @Autowired
    public BookController(BookService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", universityService.getAll());
        model.addAttribute("newBook", new Book());
        return "books/index";
    }

    @DeleteMapping("/books/{id}")
    public String getAll(@PathVariable("id") int id) {
        universityService.delete(id);
        return "redirect:/books";
    }

    @PostMapping("/books")
    public String create(@ModelAttribute("newAuthor") Book book) {
        universityService.save(book);
        return "redirect:/books";
    }
}
