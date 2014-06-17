package org.pa.library.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.pa.library.model.Library;
public class XMLHelper {
	
	
	public static void writeToXML(Library library) {
		try {
			JAXBContext context = JAXBContext.newInstance(Library.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			FileWriter fileWriter = new FileWriter(Library.LIBRARY_FILE, false);
			marshaller.marshal(library, fileWriter);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
	
	public static Library readFromXML() {
		File libraryFile = new File(Library.LIBRARY_FILE);
		boolean fileExists = libraryFile.exists() && libraryFile.length()>0;
		if (! fileExists)
			throw new RuntimeException("File '" + libraryFile.getPath() + "' does not exist.");

		try {
			JAXBContext context = JAXBContext.newInstance(Library.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			FileReader fileReader = new FileReader(libraryFile);
			Library unmarshalledLibrary = (Library) unmarshaller.unmarshal(fileReader);
			return unmarshalledLibrary;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}


}
