package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DataMiner {
	
	private FileImportService fileImport;
	MapperService mapper;
	
	public DataMiner(FileImportService fileImport, MapperService mapper) {
		
		this.fileImport = fileImport;
		this.mapper=mapper;
		
	}
	
	public List<Person> getListOfPeople(String path){
		return mapper.mapStringsToPeople(fileImport.importFile(path));
	}


	


	
}
