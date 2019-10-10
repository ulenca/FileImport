package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperService {
	
	//Maps list of list of strings where words are separated by comma to list of people
	public List<Person> mapStringsToPeople(List<String> listOfStrings){
		
		if(listOfStrings.isEmpty()) throw new IllegalArgumentException("List of strings cannot be empty");
		
		List<Person> people = new ArrayList<>();

		for (String s:listOfStrings) {
			String[] wordsInRow = s.split(",");
			
			if(wordsInRow.length==4) {
				people.add(new PersonWithPhone(wordsInRow[0], wordsInRow[1], new Date(), wordsInRow[3]));
			} else if (wordsInRow.length==3) {
				people.add(new Person(wordsInRow[0], wordsInRow[1], new Date()));
			} else {
				throw new IllegalArgumentException("File should be formatted Name,LastName,RRRR-MM-DD,phone-optionally");
			}
			
		}
		
		return people;
		
	}

}
