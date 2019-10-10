package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DataMiner {
	
	private List<Person> listOfPeople;
	
	public DataMiner(FileImportService fileImport, MapperService mapper, String path) {

		listOfPeople = mapper.mapStringsToPeople(fileImport.importFile(path));
	}

	public static void main(String[] args) {
		
		FileImportService fileImport = new TextFileImport();
		MapperService mapper = new MapperService();
		
		DataMiner raportAboutPeople = new DataMiner(fileImport,mapper,"src\\test\\files\\RegularFileWithDifferentData");

		System.out.println("Number of people equals " 
				+ raportAboutPeople.countPeople());
		
		System.out.println();
				
        raportAboutPeople.findTheOldersPersonWithPhoneNumber();

	}

	public int countPeople() {
		
		return listOfPeople.size();
		
	}
	
	//prints a list of the oldest people with phones, in case two or more people with phone are the same, oldest age
	public void findTheOldersPersonWithPhoneNumber() {
		
		if(listOfPeople.size()==1) {
			if(listOfPeople.get(0).getPhoneNumber() == null) {
				System.out.println("No people with phone number");
				return;
			}else {
				System.out.println("Data of the oldest person/people with phone number:");
				listOfPeople.forEach((e)->System.out.println(e.toString()));
				return;
			}
		}
		
		List<Person> sortedList = new ArrayList<>(listOfPeople);
		List<Person> oldestPeopleWithPhone = new ArrayList<>();
		
		//Sorts collection according to overriden compareTo method inside Person class; for details check compareTo method definition
		Collections.sort(sortedList);
		
		
		System.out.println();
		
		//first person in the list is the oldest one provided he/she has a phone number
		if(sortedList.get(0).getPhoneNumber() != null) {
			oldestPeopleWithPhone.add(sortedList.get(0));			
		}else {
			System.out.println("No people with phone number");
			return;
		}

		//checking if there are another people with the same age as oldest person with phone
		for (int i = 1; i<sortedList.size(); i++) {
			if (sortedList.get(i).compareTo(sortedList.get(i-1))==0) {
				oldestPeopleWithPhone.add(sortedList.get(i));
			}else {
				break;
			}
		}
		
		System.out.println("Data of the oldest person/people with phone number:");
		oldestPeopleWithPhone.forEach((e)->System.out.println(e.toString()));
		
	}
	
}
