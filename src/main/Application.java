package main;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		if(args.length!=1) {
			System.out.println("Please give a file path as parameter");
			System.exit(1);
		}
		
		FileImportService fileImport = new TextFileImport();
		MapperService mapper = new MapperService();
		DataMiner dataMiner = new DataMiner(fileImport,mapper);
		List<Person> listOfPeople = dataMiner.getListOfPeople(args[0]);
		DataSearcher dataSearcher = new DataSearcher();

		System.out.println("Number of people equals " 
				+ dataSearcher.countPeople(listOfPeople));
		
		System.out.println("Oldest person/people with phone: ");
		List<Person> listOfOldestPeople = dataSearcher
				.findTheOldestPersonWithPhoneNumber(listOfPeople);
		
		if(listOfOldestPeople.isEmpty()) {
			System.out.println("No people with phone number");
		} else {
			listOfOldestPeople.forEach((person)->System.out.println(person));
		}
		
	}

}
