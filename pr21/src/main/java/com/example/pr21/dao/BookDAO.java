package com.example.pr21.dao;

import com.example.pr21.models.Book;
import com.example.pr21.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {
    Book findByName(String name);
}
