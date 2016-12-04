package com.personal.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	public List<Book> findByType(String type);
}
