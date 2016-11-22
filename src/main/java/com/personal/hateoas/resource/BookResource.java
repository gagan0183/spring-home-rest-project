package com.personal.hateoas.resource;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class BookResource extends ResourceSupport {
	private String isbn;
	private String bookName;
	private String type;
	private Date startDate;
	private Date completeDate;
	private boolean revision;

	public BookResource() {

	}

	public BookResource(String isbn, String bookName, String type, Date startDate, Date completeDate,
			boolean revision) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.type = type;
		this.startDate = startDate;
		this.completeDate = completeDate;
		this.revision = revision;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public boolean isRevision() {
		return revision;
	}

	public String getType() {
		return type;
	}
}
