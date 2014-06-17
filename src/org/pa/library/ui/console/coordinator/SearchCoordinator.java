package org.pa.library.ui.console.coordinator;

import java.util.List;
import org.pa.library.model.Book;
import org.pa.library.model.Library;
import org.pa.library.ui.console.ctrl.functionCtrl.BookRequest;
import org.pa.library.ui.console.ctrl.functionCtrl.SearchCtrl;

public class SearchCoordinator implements Coordinator{
    private Library library;
    private BookRequest bookRequest = new BookRequest();
    private SearchCtrl searchCtrl = new SearchCtrl();
    
    
    public SearchCoordinator(Library library) {
        this.library = library;
    }

    public void execute() {   
        
        Book request = bookRequest.receiveRequest();
        List<Book> foundBooks = searchCtrl.searchBook(library, request);
        searchCtrl.showFoundBooks(library, foundBooks);
        
    }

}
