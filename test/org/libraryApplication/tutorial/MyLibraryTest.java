package org.libraryApplication.tutorial;

import java.util.ArrayList;
import junit.framework.TestCase;

public class MyLibraryTest extends TestCase {

	private Book book1;
	private Book book2;
	private MyLibrary testLibrary;
	private Person person1;
	private Person person2;

	public void testMyLibrary(){
		MyLibrary testLibrary = new MyLibrary("Test");
		
		assertEquals("Test", testLibrary.name);
		
		assertTrue(testLibrary.books instanceof ArrayList);
		assertTrue(testLibrary.borrowers instanceof ArrayList);
	}
	
	public void setup(){
		book1 = new Book("Great Expectations");
		book2 = new Book("Paradise Lost");
		
		person1 = new Person();
		person1.setName("Jim");
		
		person2 = new Person();
		person2.setName("Sue");
		
		testLibrary = new MyLibrary("Test Library");
	}
	
	public void testAddBook(){
		//create test objects
		setup();
		
		//test initial size is 0
		assertEquals(0, testLibrary.getBooks().size());
		
		testLibrary.addBook(book1);
		testLibrary.addBook(book2);
		assertEquals(2, testLibrary.getBooks().size());
		assertEquals(0, testLibrary.getBooks().indexOf(book1));
		assertEquals(1, testLibrary.getBooks().indexOf(book2));
		
		testLibrary.removeBook(book1);
		
		assertEquals(1, testLibrary.getBooks().size());
		assertEquals(0, testLibrary.getBooks().indexOf(book2));
		
		testLibrary.removeBook(book2);
		
		assertEquals(0, testLibrary.getBooks().size());
		
	}
	
	public void testAddPerson(){		
		//create test objects
		setup();
		
		//test initial size is 0
		assertEquals(0, testLibrary.getBorrowers().size());
		
		testLibrary.addBorrower(person1);
		testLibrary.addBorrower(person2);
		assertEquals(2, testLibrary.getBorrowers().size());
		assertEquals(0, testLibrary.getBorrowers().indexOf(person1));
		assertEquals(1, testLibrary.getBorrowers().indexOf(person2));
		
		testLibrary.removeBorrower(person1);
		
		assertEquals(1, testLibrary.getBorrowers().size());
		assertEquals(0, testLibrary.getBorrowers().indexOf(person2));
		
		testLibrary.removeBorrower(person2);
		
		assertEquals(0, testLibrary.getBorrowers().size());
		
	}
	
	public void testCheckOut(){
		//set up objects
		setup();
		addItems();
		
		//test checkOut
		assertTrue("Unable to check out book!", testLibrary.checkOutBook(book1, person1));
		assertEquals("Jim",book1.getBorrower().getName());
		assertFalse("Book was already checked out!", testLibrary.checkOutBook(book1, person1));
		
		//test checkIn
		assertTrue("Book check in failed.", testLibrary.checkIn(book1));
		assertFalse("Book was already checked in.", testLibrary.checkIn(book1));
		assertFalse("Book was never checked out.", testLibrary.checkIn(book2));
		
		//additional tests for maximumBooks
		setup();
		addItems();
		person1.setMaximumBooks(1);
		
		assertTrue("First book did not check out.", testLibrary.checkOutBook(book1, person1));
		assertFalse("Second book should not have checked out successfully.", testLibrary.checkOutBook(book2, person1));
		
	}

	public void testGetBooksForPerson(){
		setup();
		addItems();
		
		assertEquals(0, testLibrary.getBooksForPerson(person1).size());
		
		testLibrary.checkOutBook(book1, person1);
		
		ArrayList<Book> testBookList = testLibrary.getBooksForPerson(person1);
		
		assertEquals(1, testBookList.size());
		assertEquals(0, testBookList.indexOf(book1));
		
		testLibrary.checkOutBook(book2, person1);
		testBookList = testLibrary.getBooksForPerson(person1);
		
		assertEquals(2, testBookList.size());
		assertEquals(1, testBookList.indexOf(book2));
		
	}

	private void addItems() {
		testLibrary.addBook(book1);
		testLibrary.addBook(book2);
		testLibrary.addBorrower(person1);
		testLibrary.addBorrower(person2);
	}
	
}
