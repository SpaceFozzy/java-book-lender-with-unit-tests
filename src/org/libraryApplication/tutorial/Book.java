package org.libraryApplication.tutorial;

public class Book {

	String title;
	String author;
	Person borrower;

	public Book(String initialTitle) {
		this.title = initialTitle;
		this.author = "unknown author";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBorrower(Person borrower) {
		this.borrower = borrower;
	}

	public Person getBorrower() {
		return this.borrower;
	}

}
