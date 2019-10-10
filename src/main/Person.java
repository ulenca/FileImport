package main;

import java.time.LocalDate;


public class Person implements Comparable<Person>{

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private int age;
	private String phoneNumber;
	
	public Person(String firstName, String lastName, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.age = calculateAge();
	}
	
	public Person(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber=phoneNumber;
		this.age = calculateAge();
	}

	@Override
	public String toString() {
		return "Imiê: " + firstName + ", Nazwisko: " + lastName + ", Wiek: " + age + ", Telefon: " + phoneNumber;
	}
	
	private int calculateAge() {
		if (LocalDate.now().isBefore(dateOfBirth)) {
			throw new IllegalArgumentException("Wrong date! Person " + this.toString() + "has not been born yet!");
			}
		return LocalDate.now().getYear()-dateOfBirth.getYear();
	}

	@Override
	public int compareTo(Person otherPerson) {
			return Integer.compare(this.age, otherPerson.age);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public int getAge() {
		return age;
	}
	
}
