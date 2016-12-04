package com.personal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.model.Book;
import com.personal.rep.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bokRepository;

	@Override
	public Book addBook(Book book) {
		return bokRepository.save(book);
	}

	@Override
	public List<Book> getBooks(String type) {
		return bokRepository.findByType(type);
	}

}
