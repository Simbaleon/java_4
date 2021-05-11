package com.example.pr14.controllers;

import com.example.pr14.dao.BookDAO;
import com.example.pr14.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private final BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", bookDAO.getAll());
        model.addAttribute("newBook", new Book());
        return "books/index";
    }

    @DeleteMapping("/books/{id}")
    public String getAll(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }

    @PostMapping("/books")
    public String create(@ModelAttribute("newBook") Book book) {
        bookDAO.save(book);
        return "redirect:/books";
    }
}
