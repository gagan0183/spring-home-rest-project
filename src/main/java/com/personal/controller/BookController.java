package com.personal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.exception.PostBookException;
import com.personal.hateoas.assembler.BookResourceAssembler;
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
	public ResponseEntity<SuccessMessage> addBook(@RequestBody Book book) {
		LOGGER.info("in addBook");

		Book returnBook = bookService.addBook(book);
		if (returnBook == null) {
			throw new PostBookException(messageSource.getMessage("postbookexception.message", null, null));
		}
		SuccessMessage successMessage = new SuccessMessage(HttpStatus.OK.value(),
				messageSource.getMessage("successbpost.message", null, null));
		return new ResponseEntity<SuccessMessage>(successMessage, HttpStatus.OK);
	}
}
