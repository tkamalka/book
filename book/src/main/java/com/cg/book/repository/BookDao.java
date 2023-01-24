package com.cg.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.book.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

}
