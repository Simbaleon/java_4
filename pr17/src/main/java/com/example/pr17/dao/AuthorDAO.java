package com.example.pr17.dao;

import com.example.pr17.models.Author;
import com.example.pr17.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Integer> {
    @Transactional
    void deleteAllByBook(Book book);
}
