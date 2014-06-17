package org.pa.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.pa.library.model.Book;

@XmlRootElement
public class Library {

	public static final String LIBRARY_FILE = "Library.xml"; //TODO AS move it to the LibrarySystem and put here a field storing a file name from which library was read.
	
	@XmlElement
	private List<Book> books;	
	
	public Library() {
		books = new ArrayList<Book>();
	}
			
	public List<Book> getBooks() {
		return books;
	}
}