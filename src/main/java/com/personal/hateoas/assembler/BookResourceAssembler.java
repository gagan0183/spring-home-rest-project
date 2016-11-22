package com.personal.hateoas.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.personal.controller.BookController;
import com.personal.hateoas.resource.BookResource;
import com.personal.model.Book;

@Component
public class BookResourceAssembler extends ResourceAssemblerSupport<Book, BookResource> {

	public BookResourceAssembler() {
		super(BookController.class, BookResource.class);
	}

	@Override
	public BookResource toResource(Book book) {
		BookResource bookResource = createResourceWithId(book.getIsbn(), book);
		return bookResource;
	}

	@Override
	protected BookResource instantiateResource(Book book) {
		return new BookResource(book.getIsbn(), book.getBookName(), book.getType(), book.getStartDate(),
				book.getCompleteDate(), book.isRevision());
	}
}
