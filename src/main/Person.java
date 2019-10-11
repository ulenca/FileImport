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
	
	private int calculateAge() {
		if (LocalDate.now().isBefore(dateOfBirth)) {
			throw new IllegalArgumentException("Wrong date! Person " + this.toString() + "has not been born yet!");
			}
		return LocalDate.now().getYear()-dateOfBirth.getYear();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public int compareTo(Person otherPerson) {
			return Integer.compare(this.age, otherPerson.age);
	}
	
	@Override
	public String toString() {
		return "Imiê: " + firstName + ", Nazwisko: " + lastName + ", Wiek: " + age + ", Telefon: " + phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
	
	
}
