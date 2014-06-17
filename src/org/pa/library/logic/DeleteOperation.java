package org.pa.library.logic;
import static org.pa.library.dao.XMLHelper.writeToXML;

import org.pa.library.model.Library;

public class DeleteOperation {
      
    public void deleteBook(Library library, int index) {
        library.getBooks().remove(index);   
        writeToXML(library);
    }
}
