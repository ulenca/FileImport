package main;

import java.nio.file.Path;
import java.util.List;

public interface FileImportService {
	
	//imports a file and return list of strings which correspond consecutive lines
	public List<String> importFile(Path path);
 
}
