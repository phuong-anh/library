package org.pa.library.ui.console.coordinator;

import java.util.List;
import org.pa.library.model.Book;
import org.pa.library.model.Library;
import org.pa.library.ui.console.viewer.functionViewers.BookListViewer;

public class ListCoordinator implements Coordinator{
    private BookListViewer bookListViewer = new BookListViewer();
    private Library library;
    
public ListCoordinator(Library library) {
        this.library = library;
    }

public void execute() {   
    
    List<Book> books = library.getBooks();
    bookListViewer.listAllBooks(library, books);
}
}
