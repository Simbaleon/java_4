package com.example.pr19.services;

import com.example.pr19.dao.AuthorDAO;
import com.example.pr19.dao.BookDAO;
import com.example.pr19.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {
    private final BookDAO bookDAO;
    private final AuthorDAO authorDAO;

    @Autowired
    public BookService(BookDAO bookDAO, AuthorDAO authorDAO) {
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
    }

    public List<Book> getAll() {
        log.info("Find all books");
        return bookDAO.findAll();
    }

    public void delete(int id) {
        log.info("Delete book by id: " + id);
        Optional<Book> optionalBook = bookDAO.findById(id);

        if (optionalBook.isEmpty()) {
            return;
        }

        authorDAO.deleteAllByBook(optionalBook.get());
        bookDAO.deleteById(id);
    }

    public void save(Book book) {
        log.info("Save book with id: " + book.getId());
        bookDAO.save(book);
    }
}
