package org.pa.library.logic;

import static org.pa.library.dao.XMLHelper.writeToXML;

import org.pa.library.model.Library;
import org.pa.library.model.Book;

public class AddBookOperation {
    
    public void addBook(Library library, Book book) {
        library.getBooks().add(book);
        writeToXML(library);
    }
}

