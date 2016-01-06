package org.libraryApplication.tutorial;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	
	public void testBook(){
		Book newBook = new Book("Great Expectations");
		assertEquals("Great Expectations", newBook.title);
		assertEquals("unknown author", newBook.author);
	}
	
	public void testGetBorrower(){
		Book testBook = new Book("War and Peace");
		Person borrower = new Person();
		borrower.setName("Jon");
		
		//method to set the person who has rented the book
		testBook.setBorrower(borrower);
		
		String testName = testBook.getBorrower().getName();
		assertEquals("Jon", testName);
	}
	
	public void testToString(){
		Book testBook = new Book("War and Peace");
		Person borrower = new Person();
		borrower.setName("Jon"); 
		
		assertEquals("War and Peace by unknown author: AVAILABLE", testBook.toString());
		testBook.setBorrower(borrower);
		assertEquals("War and Peace by unknown author: CHECKED OUT by Jon", testBook.toString());
	}
	
}
