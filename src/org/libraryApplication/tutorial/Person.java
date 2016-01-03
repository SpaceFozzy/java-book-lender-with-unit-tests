package org.libraryApplication.tutorial;

public class Person {

	private String name;
	private int maximumBooks;
	
	public Person(){
		name = "unknown name";
		maximumBooks = 3;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}

	public int getMaximumBooks() {
		return maximumBooks;
	}

	public void setMaximumBooks(int newMaximum) {
		this.maximumBooks = newMaximum;
	}
}
