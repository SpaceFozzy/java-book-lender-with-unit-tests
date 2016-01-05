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

	public String getName() {
		return name;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public ArrayList<Person> getBorrowers() {
		return borrowers;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public void removeBook(Book book) {
		this.books.remove(book);
	}

	public void addBorrower(Person person) {
		this.borrowers.add(person);
	}

	public void removeBorrower(Person person) {
		this.borrowers.remove(person);
	}

	public boolean checkOutBook(Book book, Person person) {
		if (book.getBorrower()!=null){
			return false;
		} else {
			book.setBorrower(person);
			return true;
		}
	}

	public boolean checkIn(Book book) {
		// TODO Auto-generated method stub
		if (book.getBorrower() != null){
			book.setBorrower(null);
			return true;
		} else {
			return false;
		}
	}

}