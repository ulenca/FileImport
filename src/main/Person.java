package main;

import java.util.Date;

public class Person {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	public Person(String firstName, String lastName, Date dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + "]";
	}

	
}
