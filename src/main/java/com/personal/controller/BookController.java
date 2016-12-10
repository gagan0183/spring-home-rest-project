package com.personal.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.exception.PostBookException;
import com.personal.hateoas.assembler.BookResourceAssembler;
import com.personal.hateoas.resource.BookResource;
import com.personal.model.Book;
import com.personal.service.BookService;
import com.personal.util.SuccessMessage;

@RestController
public class BookController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class.getPackage().getName());

	@Autowired
	private BookService bookService;

	@Autowired
	private BookResourceAssembler bookResourceAssembler;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> addBook(@Valid @RequestBody Book book) {
		LOGGER.info("in addBook");

		Book returnBook = bookService.addBook(book);
		if (returnBook == null) {
			throw new PostBookException(messageSource.getMessage("postbookexception.message", null, null));
		}
		SuccessMessage successMessage = new SuccessMessage(HttpStatus.OK.value(),
				messageSource.getMessage("successbpost.message", null, null));
		return new ResponseEntity<SuccessMessage>(successMessage, HttpStatus.OK);
	}

	@RequestMapping(value = "/book/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookResource>> getBooks(@PathVariable("type") String type) {
		LOGGER.info("in getBook");

		List<Book> books = bookService.getBooks(type);
		if (books.size() == 0) {

		}
		List<BookResource> bookResources = bookResourceAssembler.toResources(books);
		return new ResponseEntity<List<BookResource>>(bookResources, HttpStatus.OK);
	}
}
