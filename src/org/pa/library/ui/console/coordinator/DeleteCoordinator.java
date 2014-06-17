package org.pa.library.ui.console.coordinator;

import org.pa.library.logic.DeleteOperation;
import org.pa.library.model.Library;
import org.pa.library.ui.console.ctrl.functionCtrl.DeleteCtrl;
import org.pa.library.ui.console.viewer.functionViewers.BookManageViewer;
import org.pa.library.ui.console.viewer.functionViewers.DeleteViewer;

public class DeleteCoordinator implements Coordinator{
   // what's the difference between putting initialization here and in constructor?
    private DeleteViewer deleteViewer         = new DeleteViewer();
    private DeleteCtrl deleteCtrl             = new DeleteCtrl();
    private DeleteOperation deleteOperation   = new DeleteOperation();
    private BookManageViewer bookManageViewer = new BookManageViewer();    
    private Library library;
    
public DeleteCoordinator(Library library) {
    this.library = library;
    }

public void execute(){
    
    deleteViewer.askIndexDelete();
    int index = deleteCtrl.getIndexDelete();
    boolean indexCorrect = validateIndexDelete(index);                
    if(indexCorrect) {
    deleteOperation.deleteBook(library, index);
    deleteViewer.answerBookDeleteSuccess();
    }
    else bookManageViewer.answerIndexFail();
    
}

private boolean validateIndexDelete(int index) {
    boolean indexCorrect = index < library.getBooks().size() && index >= 0;
    return indexCorrect;
}
}
