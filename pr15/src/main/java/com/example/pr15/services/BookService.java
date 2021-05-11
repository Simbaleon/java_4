package com.example.pr15.services;

import com.example.pr15.dao.BookDAO;
import com.example.pr15.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getAll() {
        return bookDAO.findAll();
    }

    public void delete(int id) {
        bookDAO.deleteById(id);
    }

    public void save(Book student) {
        bookDAO.save(student);
    }
}
