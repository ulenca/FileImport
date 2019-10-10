package main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class MapperService {
	
	//Maps list of list of strings where words are separated by comma to list of people
	public List<Person> mapStringsToPeople(List<String> listOfStrings){
		
		if(listOfStrings.isEmpty()) throw new IllegalArgumentException("List of rows cannot be empty");
		
		List<Person> people = new ArrayList<>();

		for (String s:listOfStrings) {
			
			String[] wordsInRow = s.split(",");
			
			try {
				if(wordsInRow.length==4) {
					people.add(new Person(wordsInRow[0], wordsInRow[1], LocalDate.parse(wordsInRow[2]), wordsInRow[3]));
				} else if (wordsInRow.length==3) {
					people.add(new Person(wordsInRow[0], wordsInRow[1], LocalDate.parse(wordsInRow[2])));
				} else {
					throw new IllegalArgumentException("Row sould be formatted in teh following manner: Name,LastName,RRRR-MM-DD,phone-optionally");
				}
			}catch(DateTimeParseException e){
				System.out.println("Date should be formatted in the following manner YYYY-MM-DD. "
						+ "Please correct the file and reload, because given list doesn not contain broken record " + e);
				
			}
		}
		
		return people;
		
	}

}
