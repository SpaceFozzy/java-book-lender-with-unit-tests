package org.libraryApplication.tutorial;

import java.util.ArrayList;

public class MyLibrary {

	String name;
	ArrayList<Book> books;
	ArrayList<Person> borrowers;

	public MyLibrary(String libraryName) {
		this.name = libraryName;
		this.books = new ArrayList<Book>();
		this.borrowers = new ArrayList<Person>();
	}

}
