package org.pa.library.ui.console.coordinator;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import java.util.ArrayList;
import java.util.List;
import org.pa.library.logic.AddBookOperation;
import org.pa.library.model.Book;
import org.pa.library.model.Library;
import org.pa.library.ui.console.ctrl.functionCtrl.AddCtrl;
import org.pa.library.ui.console.viewer.functionViewers.BookListViewer;
import org.pa.library.ui.console.viewer.functionViewers.BookManageViewer;

public class AddCoordinator implements Coordinator{
    private AddCtrl addCtrl                   = new AddCtrl();
    private BookManageViewer bookManageViewer = new BookManageViewer();
    private BookListViewer bookListViewer     = new BookListViewer(); 
    private AddBookOperation addBookOperation = new AddBookOperation();
    private Library library;
 
    public AddCoordinator(Library library) {
        this.library = library;
    }

    public void execute() { 
        
        List<Book> newBooks = new ArrayList<Book>();
        boolean moreBook = true;
        while (moreBook) {
            Book newBook = addCtrl.enterBook();
            newBooks.add(newBook);        
            addBookOperation.addBook(library, newBook);//every time a new book is entered by the user, it is added to the library.
           
            
        bookManageViewer.askMoreBookAdd();
        String answer = readLineFromConsole();
        if (!answer.equals("yes"))
            moreBook = false;
        }
        
        if (newBooks.size() > 0) {
            bookListViewer.listNewBooks(newBooks);
            bookManageViewer.answerBookAddSuccess();}
    }
}
        
    

