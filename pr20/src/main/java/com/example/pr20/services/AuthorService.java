package com.example.pr20.services;

import com.example.pr20.dao.AuthorDAO;
import com.example.pr20.dao.BookDAO;
import com.example.pr20.dto.AuthorDTO;
import com.example.pr20.models.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorService {
    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;

    @Autowired
    public AuthorService(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    public List<Author> getAll() {
        log.info("Find all authors");
        return authorDAO.findAll();
    }

    public void delete(int id) {
        log.info("Delete author by id: " + id);
        authorDAO.deleteById(id);
    }

    public void save(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setMiddleName(authorDTO.getMiddleName());
        author.setBook(bookDAO.findByName(authorDTO.getNameBook()));

        log.info("Save author with id: " + author.getId());
        authorDAO.save(author);
    }

    public List<Author> filterAuthors(
            String bookName, String firstName, String middleName, String lastName
    ) {
        log.info("Filter authors by bookName=" + bookName +
                ", firstName=" + firstName +
                ", middleName=" + middleName +
                ", lastName=" + lastName);

        return authorDAO
                .findAllAuthorsByBookNameAndFirstNameAndMiddleNameAndLastName(
                        bookName, firstName, middleName, lastName);
    }
}
