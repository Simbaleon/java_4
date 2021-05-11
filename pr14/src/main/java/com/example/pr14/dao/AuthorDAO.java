package com.example.pr14.dao;

import com.example.pr14.models.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorDAO {
    private List<Author> authorList = new ArrayList<>();
    {
        Author author = new Author();
        author.setId(1);
        author.setFirstName("Пушкин");
        author.setLastName("Александр");
        author.setMiddleName("Сергеевич");
        authorList.add(author);
    }


    public void save(Author author) {
        author.setId(authorList.size());
        authorList.add(author);
    }

    public void delete(int id) {
        for (int i = 0; i < authorList.size(); i++) {
            if (authorList.get(i).getId() == id) {
                authorList.remove(i);
                break;
            }
        }
    }

    public List<Author> getAll() {
        return authorList;
    }
}
