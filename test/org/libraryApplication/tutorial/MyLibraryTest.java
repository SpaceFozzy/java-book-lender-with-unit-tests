package org.libraryApplication.tutorial;

import java.util.ArrayList;
import junit.framework.TestCase;

public class MyLibraryTest extends TestCase {

	public void testMyLibrary(){
		MyLibrary testLibrary = new MyLibrary("Test");
		
		assertEquals("Test", testLibrary.name);
		
		assertTrue(testLibrary.books instanceof ArrayList);
		assertTrue(testLibrary.borrowers instanceof ArrayList);
	}
	
}
