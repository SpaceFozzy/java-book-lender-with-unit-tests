package org.libraryApplication.tutorial;

import junit.framework.TestCase;

public class PersonTest extends TestCase {

	public void testPerson() {
		Person testPerson = new Person();
		assertEquals("unknown name", testPerson.getName());
		assertEquals(3, testPerson.getMaximumBooks());
	}

	public void testSetName() {
		Person testPerson = new Person();
		testPerson.setName("Fred");
		assertEquals("Fred",testPerson.getName());
		
	}

	public void testSetMaximumBooks() {
		Person testPerson = new Person();
		testPerson.setMaximumBooks(5);
		assertEquals(5, testPerson.getMaximumBooks());
	}

	public void testToString(){
		Person testPerson = new Person();
		testPerson.setName("Jon");
		testPerson.setMaximumBooks(7);
		String testString = "Jon: 7 books";
		assertEquals(testString, testPerson.toString());
	}
	
}
