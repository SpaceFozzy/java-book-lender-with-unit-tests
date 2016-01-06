package org.libraryApplication.tutorial;

import java.util.ArrayList;

import junit.framework.TestListener;

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
		if (book.getBorrower()!=null 
				|| this.getBooksForPerson(person).size() >= person.getMaximumBooks()
		){
			return false;
		} else {
			book.setBorrower(person);
			return true;
		}
	}

	public boolean checkIn(Book book) {
		if (book.getBorrower() != null){
			book.setBorrower(null);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Book> getBooksForPerson(Person person) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book thisBook : this.getBooks()) {
			if (thisBook.getBorrower()!=null && thisBook.getBorrower().getName().equals(person.getName())) {
				result.add(thisBook);
			}
		}
		return result;
	}

	public ArrayList<Book> getAvailableBooks() {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book thisBook : this.getBooks()){
			if (thisBook.getBorrower() == null){
				result.add(thisBook);
			}
		}
		return result;
	}

	public ArrayList<Book> getUnavailableBooks() {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book thisBook : this.getBooks()){
			if (thisBook.getBorrower() != null){
				result.add(thisBook);
			}
		}
		return result;
	}
	
	public String toString(){
		return this.getName()+": "+this.getBooks().size()+" books, "+this.getBorrowers().size()+" borrowers" ;
	}
	
	public static void main(String[] args) {
		//create a new MyLibrary
		MyLibrary mainLibrary = new MyLibrary("Jon's Library");
		
		Book book1 = new Book("A Brave New World");
		Book book2 = new Book("Paradise Lost");
		book1.setAuthor("Aldous Huxley");
		book2.setAuthor("John Milton");
		mainLibrary.addBook(book1);
		mainLibrary.addBook(book2);
		
		Person reid = new Person();
		Person josh = new Person();
		reid.setName("Reid");
		josh.setName("Josh");
		mainLibrary.addBorrower(reid);
		mainLibrary.addBorrower(josh);
		
		System.out.println("New library created...");
		mainLibrary.printStatus();
		
		System.out.println("Checking out Brave New World to Josh...\n");
		mainLibrary.checkOutBook(book1, josh);
		mainLibrary.printStatus();
		
//		System.out.println("Checking out Paradise Lost to Reid");
//		mainLibrary.checkOutBook(book2, reid);
		
		System.out.println("Do some more stuff...\n");
		mainLibrary.checkIn(book1);
		mainLibrary.checkOutBook(book2,reid);
		mainLibrary.printStatus();
	}

	private void printStatus() {
		System.out.println("Status Report of " + this.getName() + "\n"
				+ this.toString());
		for (Book thisBook : this.getBooks()){
			System.out.println(thisBook);
		}
		for (Person thisPerson : this.getBorrowers()){
			int count = this.getBooksForPerson(thisPerson).size();
			System.out.println(thisPerson.getName() + " has " + count
					+ " books");
		}
		
		System.out.println("Books Available: "+this.getAvailableBooks().size());
		System.out.println("Books Borrowed: "+this.getUnavailableBooks().size());
		
		System.out.println("---- End of Status Report ----\n");
		
		
		
	}

}
