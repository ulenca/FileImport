package main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataMiner {

	public static void main(String[] args) {
		
		FileImportService fileImport = new TextFileImport();
		MapperService mapper = new MapperService();
		Path path = Paths.get("src\\test\\files\\RegularFileWithDifferentData");
		fileImport.importFile(path).forEach(System.out::println);
		System.out.println();
		mapper.mapStringsToPeople(fileImport.importFile(path)).forEach((e)->System.out.println(e.toString()));
		
/*		DataMiner raportAboutPeople = new DataMiner();

		System.out.println("Number of people equals" 
				+ raportAboutPeople.countPeople());
		
		System.out.println("Data of the oldest person with phone number" 
				+ raportAboutPeople.findTheOldersPersonWithPhoneNumber().toString());
*/
	}

	public int countPeople() {
		
		return 0;
		
	}
	
	//returns a list in case two or more people with phone are the same, oldest age
	public List<Person> findTheOldersPersonWithPhoneNumber() {
	
		return null;
		
	}
	
}
