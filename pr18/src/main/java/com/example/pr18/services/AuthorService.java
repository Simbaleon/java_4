package com.example.pr18.services;

import com.example.pr18.dao.AuthorDAO;
import com.example.pr18.dao.BookDAO;
import com.example.pr18.dto.AuthorDTO;
import com.example.pr18.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;

    @Autowired
    public AuthorService(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    public List<Author> getAll() {
        return authorDAO.findAll();
    }

    public void delete(int id) {
        authorDAO.deleteById(id);
    }

    public void save(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setMiddleName(authorDTO.getMiddleName());
        author.setBook(bookDAO.findByName(authorDTO.getNameBook()));
        authorDAO.save(author);
    }

    public List<Author> filterAuthors(
            String bookName, String firstName, String middleName, String lastName
    ) {
        return authorDAO
                .findAllAuthorsByBookNameAndFirstNameAndMiddleNameAndLastName(
                        bookName, firstName, middleName, lastName);
    }
}
