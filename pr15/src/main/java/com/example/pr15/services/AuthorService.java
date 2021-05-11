package com.example.pr15.services;

import com.example.pr15.dao.AuthorDAO;
import com.example.pr15.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorService(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public List<Author> getAll() {
        return authorDAO.findAll();
    }

    public void delete(int id) {
        authorDAO.deleteById(id);
    }

    public void save(Author author) {
        authorDAO.save(author);
    }
}
