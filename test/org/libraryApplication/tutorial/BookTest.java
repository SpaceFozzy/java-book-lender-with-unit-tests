package org.libraryApplication.tutorial;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	
	public void testBook(){
		Book newBook = new Book("Great Expectations");
		assertEquals("Great Expectations", newBook.title);
		assertEquals("unknown author", newBook.author);
	}
	
}
