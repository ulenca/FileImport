package main;

import java.util.Date;

public class PersonWithPhone extends Person{

	private String phoneNumber;
	
	public PersonWithPhone(String firstName, String lastName, Date dateOfBirth, String phoneNumber) {
		super(firstName, lastName, dateOfBirth);
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return super.toString() + "[phoneNumber=" + phoneNumber + "]";
	}


	
}
