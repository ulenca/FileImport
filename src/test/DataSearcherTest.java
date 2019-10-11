package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.DataSearcher;
import main.Person;

class DataSearcherTest {
	
	List<Person> listOfPeople = new ArrayList<>();
	Set<Person> expectedSet = new HashSet<>();
	List<Person> resultofSerchByTestMethod = new ArrayList<>();
	int numberOfPeople;
	DataSearcher dataSearcher = new DataSearcher();	

	@BeforeEach
    protected void init() {
		
	}
	
    @AfterEach
    protected void finalize() {
    	listOfPeople.clear();
    	expectedSet.clear();
    	resultofSerchByTestMethod.clear();
    }
    
	
	@Test
	void findTheOldestPersonWithPhoneNumberHappyPathTest() {
		
		listOfPeople.add(new Person("Agnieszka","Radwañska",LocalDate.parse("1989-03-28"),"785236956"));		
		listOfPeople.add(new Person("Jerzy","Grop",LocalDate.parse("1999-12-04")));
		listOfPeople.add(new Person("Aneta","Paszkowska",LocalDate.parse("2000-01-01"),"+483772909"));
		listOfPeople.add(new Person("Artur","Boruc",LocalDate.parse("1968-02-22")));
		listOfPeople.add(new Person("Anna","Paszkowska",LocalDate.parse("1955-11-30")));
		listOfPeople.add(new Person("Weronika","Lubicz",LocalDate.parse("1946-04-01"),"876456001"));
		listOfPeople.add(new Person("Adam","Porêba",LocalDate.parse("1890-03-04"),"909890988"));
		
		expectedSet.add(new Person("Adam","Porêba",LocalDate.parse("1890-03-04"),"909890988"));
		
		resultofSerchByTestMethod = dataSearcher.findTheOldestPersonWithPhoneNumber(listOfPeople);
		
		Set<Person> resultofSerchByTestMethodUnordered = new HashSet<>(resultofSerchByTestMethod);

		assertEquals(expectedSet, resultofSerchByTestMethodUnordered);
				
	}
	
	@Test
	void findTheOldestPeopleWithPhoneNumberHappyPathTest() {
		
		listOfPeople.add(new Person("Agnieszka","Radwañska",LocalDate.parse("1989-03-28"),"785236956"));		
		listOfPeople.add(new Person("Jerzy","Grop",LocalDate.parse("1999-12-04")));
		listOfPeople.add(new Person("Aneta","Paszkowska",LocalDate.parse("1890-01-01"),"+483772909"));
		listOfPeople.add(new Person("Artur","Boruc",LocalDate.parse("1968-02-22")));
		listOfPeople.add(new Person("Anna","Paszkowska",LocalDate.parse("1890-11-30")));
		listOfPeople.add(new Person("Weronika","Lubicz",LocalDate.parse("1946-04-01"),"876456001"));
		listOfPeople.add(new Person("Adam","Porêba",LocalDate.parse("1890-03-04"),"909890988"));
		listOfPeople.add(new Person("Aga","Jaremko",LocalDate.parse("1890-01-01"),"+483771909"));
		
		expectedSet.add(new Person("Adam","Porêba",LocalDate.parse("1890-03-04"),"909890988"));
		expectedSet.add(new Person("Aga","Jaremko",LocalDate.parse("1890-01-01"),"+483771909"));
		expectedSet.add(new Person("Aneta","Paszkowska",LocalDate.parse("1890-01-01"),"+483772909"));
				
		resultofSerchByTestMethod = dataSearcher.findTheOldestPersonWithPhoneNumber(listOfPeople);
		
		Set<Person> resultofSerchByTestMethodUnordered = new HashSet<>(resultofSerchByTestMethod);

		assertEquals(expectedSet, resultofSerchByTestMethodUnordered);
		
	}
	
	@Test 
	void findTheOldestPeopleWithPhoneNumberNoSuchPeopleTest(){
		
		listOfPeople.add(new Person("Agnieszka","Radwañska",LocalDate.parse("1989-03-28")));		
		listOfPeople.add(new Person("Jerzy","Grop",LocalDate.parse("1999-12-04")));
		listOfPeople.add(new Person("Aneta","Paszkowska",LocalDate.parse("1890-01-01")));
		listOfPeople.add(new Person("Artur","Boruc",LocalDate.parse("1968-02-22")));
		
		resultofSerchByTestMethod = dataSearcher.findTheOldestPersonWithPhoneNumber(listOfPeople);
		
		Set<Person> resultofSerchByTestMethodUnordered = new HashSet<>(resultofSerchByTestMethod);

		assertEquals(expectedSet, resultofSerchByTestMethodUnordered);	
		
	}
	
	@Test 
	void findTheOldestPeopleWithPhoneNumberOnePersonTest(){
	
	listOfPeople.add(new Person("Agnieszka","Radwañska",LocalDate.parse("1989-03-28"),"785236956"));
	
	expectedSet.add(new Person("Agnieszka","Radwañska",LocalDate.parse("1989-03-28"),"785236956"));
	
	resultofSerchByTestMethod = dataSearcher.findTheOldestPersonWithPhoneNumber(listOfPeople);
	
	Set<Person> resultofSerchByTestMethodUnordered = new HashSet<>(resultofSerchByTestMethod);

	assertEquals(expectedSet, resultofSerchByTestMethodUnordered);	
	}
	
}
