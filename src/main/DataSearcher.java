package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataSearcher {

	public int countPeople(List<Person> listOfPeople) {
		
		return listOfPeople.size();
		
	}
	public List<Person> findTheOldersPersonWithPhoneNumberNew(List<Person> listOfPeople) {

		List<Person> listOfPeopleWithPhoneNumber = listOfPeople.stream()
				.filter((person)-> person.getPhoneNumber()!=null)
				.collect(Collectors.toList());
		
		Optional<Person> oldestPerson = listOfPeopleWithPhoneNumber.stream()
				.max(Comparator.naturalOrder());
		
		if(!oldestPerson.isPresent()) {
			return new ArrayList<Person>();
		}
		
		return listOfPeopleWithPhoneNumber.stream()
				.filter((person)->person.getAge()==oldestPerson.get().getAge())
				.collect(Collectors.toList());
	}
	
	
}
