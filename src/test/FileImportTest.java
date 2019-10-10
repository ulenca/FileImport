package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.TextFileImport;

class FileImportTest{

	@Test
	void FileImportTestHappyPath() {
		
		TextFileImport textFileImport = new TextFileImport();
		List<String> listOfStrings = new ArrayList<>();
		listOfStrings.add("Agnieszka,Radwañska,1886-03-28,785236956");
		listOfStrings.add("Jerzy,Grop,1768-12-04");
		List<String> resultListOfString = textFileImport.importFile("src\\test\\files\\FileWithTwoRows");
		
		for(int i=0; i<listOfStrings.size();i++) {
			assertEquals(listOfStrings.get(i),resultListOfString.get(i));
		}
	}
	
	@Test
	void ImportEmptyFile() {
		TextFileImport textFileImport = new TextFileImport();
		assertThrows(IllegalArgumentException.class, () -> {
			textFileImport.importFile("src\\test\\files\\EmptyFile");
			} );
	}

}
