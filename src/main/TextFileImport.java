package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextFileImport implements FileImportService {
			
	@Override
	public List<String> importFile(String stringPath){
		
		Path path = Paths.get(stringPath);
		List<String> rows = new ArrayList<String>();
		
		try {
			rows = Files.readAllLines(path, Charset.forName("ISO8859_2"));
		} catch (IOException e) {
			System.out.println("File import error");
			e.printStackTrace();
		}
		
		return rows;
	}



}
