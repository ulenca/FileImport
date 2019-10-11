package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import main.MapperService;
import main.Person;

class MapperServiceTest {

	List<String> listOfStrings = new ArrayList<>();
	List<Person> expectedListOfPeople = new ArrayList<>();
	List<Person> resultProducedByMethod = new ArrayList<>();
	MapperService mapperService = new MapperService();
	
	@AfterEach
    protected void finalize() {
		listOfStrings.clear();
		expectedListOfPeople.clear();
		resultProducedByMethod.clear();
	}
	
	@Test
	void mapStringsToPeopleHappyPathTest() {

		listOfStrings.add("Agnieszka,Radwañska,1989-03-28,785236956");
		listOfStrings.add("Jerzy,Grop,1968-12-04");
		listOfStrings.add("Aneta,Paszkowska,2000-01-01,+483772909");
		listOfStrings.add("Artur,Boruc,1968-02-22");
		listOfStrings.add("Anna,Paszkowska,1955-11-30");
		listOfStrings.add("Weronika,Lubicz,1946-04-01,876456001");
		listOfStrings.add("Adam,Porêba,1890-03-04,909890988");
				
		expectedListOfPeople.add(new Person("Agnieszka","Radwañska",LocalDate.parse("1989-03-28"),"785236956"));		
		expectedListOfPeople.add(new Person("Jerzy","Grop",LocalDate.parse("1968-12-04")));
		expectedListOfPeople.add(new Person("Aneta","Paszkowska",LocalDate.parse("2000-01-01"),"+483772909"));
		expectedListOfPeople.add(new Person("Artur","Boruc",LocalDate.parse("1968-02-22")));
		expectedListOfPeople.add(new Person("Anna","Paszkowska",LocalDate.parse("1955-11-30")));
		expectedListOfPeople.add(new Person("Weronika","Lubicz",LocalDate.parse("1946-04-01"),"876456001"));
		expectedListOfPeople.add(new Person("Adam","Porêba",LocalDate.parse("1890-03-04"),"909890988"));
		
		resultProducedByMethod = mapperService.mapStringsToPeople(listOfStrings);
		
		assertEquals(expectedListOfPeople, resultProducedByMethod);
				
	}
	
	@Test
	void mapStringsToPeopleWrongFormatTest() {

		listOfStrings.add("Agnieszka,Radwañska,1989-03-28,785236956,toooMuch");
		listOfStrings.add("Jerzy,Grop,1968-12-04");
		listOfStrings.add("Ane   2000-01-01,+483772909");
		listOfStrings.add("Artur,Boruc,1968-02-22");
		listOfStrings.add("Anna,Paszkowska,1955-11-30");
		listOfStrings.add("Weronika,Lubicz,1946-04-01,876456001");
		listOfStrings.add("Adam,Porêba,1890-03-04,909890988");	 
		
        assertThrows(IllegalArgumentException.class, () -> mapperService.mapStringsToPeople(listOfStrings));
				
	}
	
}
