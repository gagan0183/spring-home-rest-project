package com.personal.service;

import java.util.List;

import com.personal.model.Book;

public interface BookService {
	public Book addBook(Book book);

	public List<Book> getBooks(String type);

	public void deleteBook(String isbn);
}
