package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TextFileImport implements FileImportService {

	@Override
	public List<String> importFile(Path path){
	
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
