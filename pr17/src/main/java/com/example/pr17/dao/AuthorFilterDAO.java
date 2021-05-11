package com.example.pr17.dao;

import com.example.pr17.models.Author;
import com.example.pr17.models.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorFilterDAO {
    @PersistenceContext
    EntityManager em;

    public List<Author> findAllAuthorsByBookNameAndFirstNameAndMiddleNameAndLastName
            (String bookName, String firstName, String middleName, String lastName)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);

        Root<Author> studentRoot = cq.from(Author.class);
        List<Predicate> predicates = new ArrayList<>();

        if (!bookName.equals("")) {
            predicates.add(cb.equal(studentRoot.get("book").get("name"), bookName));
        }

        if (!firstName.equals("")) {
            predicates.add(cb.equal(studentRoot.get("firstName"), firstName));
        }

        if (!middleName.equals("")) {
            predicates.add(cb.equal(studentRoot.get("middleName"), middleName));
        }

        if (!lastName.equals("")) {
            predicates.add(cb.equal(studentRoot.get("lastName"), lastName));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }
}
