package com.example.pr14.dao;

import com.example.pr14.models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAO {
    private List<Book> bookList = new ArrayList<>();
    {
        Book book = new Book();
        book.setId(1);
        book.setName("Капитанская дочка");
        book.setCreationDate("1836 год");
        bookList.add(book);
    }


    public void save(Book book) {
        book.setId(bookList.size());
        bookList.add(book);
    }

    public void delete(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                bookList.remove(i);
                break;
            }
        }
    }

    public List<Book> getAll() {
        return bookList;
    }
}
