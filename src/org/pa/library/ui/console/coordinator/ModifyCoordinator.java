package org.pa.library.ui.console.coordinator;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import org.pa.library.model.Book;
import org.pa.library.model.Library;
import org.pa.library.ui.console.ctrl.functionCtrl.ModifyCtrl;
import org.pa.library.ui.console.viewer.functionViewers.BookManageViewer;
import org.pa.library.ui.console.viewer.functionViewers.BookToModifyViewer;

public class ModifyCoordinator implements Coordinator{
    private Library library;
  
    private BookToModifyViewer bookToModifyViewer  = new BookToModifyViewer();
    private BookManageViewer bookManageViewer = new BookManageViewer();
    
    public ModifyCoordinator(Library library) {
        this.library = library;
        
    }       
    
    public Book selectBookToModify() {
        
        Book bookToModify = new Book();
        int indexModify = getIndexModify();
        boolean indexCorrect = validateIndexModify(indexModify);
        if (indexCorrect) {
            bookToModify = getBookToModify(bookToModify, indexModify);

            if (!bookToModify.equals(null)) {
                bookToModifyViewer.showBookToModify(bookToModify);
            } else
                bookManageViewer.answerIndexFail();
        }
        return bookToModify;
    }
    
    public Book getBookToModify(Book bookToModify, int indexModify) {
        bookToModify = library.getBooks().get(indexModify);
        return bookToModify;
    }
    
    private int getIndexModify() {
        bookToModifyViewer.askForIndexBookToModify();
        String indexModifyS = readLineFromConsole();
        int indexModify = Integer.parseInt(indexModifyS);
        indexModify = indexModify - 1;// why index -1 works but not index --
        return indexModify;
    }
    
    private boolean validateIndexModify( int indexModify) {
        boolean indexCorrect = indexModify <= library.getBooks().size() && indexModify >= 0;
        return indexCorrect;
    }


    public void execute() {
    ModifyCtrl modifyCtrl = new ModifyCtrl(library);
    boolean moreBookModify = true;
    while (moreBookModify) {
        Book bookToModify = selectBookToModify();
        Book modifiedBook = modifyCtrl.executeModifyChoice(bookToModify); 
        
        bookToModifyViewer.askMoreBookToModify();
        String answer = readLineFromConsole();
        if (answer.equals("no"))
            moreBookModify = false;        
        bookToModifyViewer.showModifiedBook(modifiedBook);
}
    }
}