package org.libraryApplication.tutorial;

public class Book {

	public String title;
	public String author;

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

}
