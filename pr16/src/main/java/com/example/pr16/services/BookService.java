package com.example.pr16.services;

import com.example.pr16.dao.AuthorDAO;
import com.example.pr16.dao.BookDAO;
import com.example.pr16.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookDAO bookDAO;
    private final AuthorDAO authorDAO;

    @Autowired
    public BookService(BookDAO bookDAO, AuthorDAO authorDAO) {
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
    }

    public List<Book> getAll() {
        return bookDAO.findAll();
    }

    public void delete(int id) {
        Optional<Book> optionalUniversity = bookDAO.findById(id);

        if (optionalUniversity.isEmpty()) {
            return;
        }

        authorDAO.deleteAllByBook(optionalUniversity.get());
        bookDAO.deleteById(id);
    }

    public void save(Book student) {
        bookDAO.save(student);
    }
}
