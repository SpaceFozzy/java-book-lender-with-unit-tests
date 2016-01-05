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
	
}
