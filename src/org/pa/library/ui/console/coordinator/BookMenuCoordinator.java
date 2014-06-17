package org.pa.library.ui.console.coordinator;

import static org.pa.library.dao.XMLHelper.readFromXML;
import org.pa.library.model.Library;
import org.pa.library.ui.console.ctrl.BookMenuCtrl;
import org.pa.library.ui.console.viewer.BookMenuViewer;

public class BookMenuCoordinator {  
    private BookMenuViewer mainMenuViewer = new BookMenuViewer(); 
    private BookMenuCtrl   mainMenuCtrl   = new BookMenuCtrl();    
   private Library library = readFromXML();
    
    public void runLibrary() {        
         
        boolean moreOperation = true;
        while (moreOperation) {
            mainMenuViewer.showMenu();
            String userChoice = mainMenuCtrl.readUserChoice(mainMenuViewer);
            Coordinator coordinator = null;
            if (userChoice.equals("1")) {  
                coordinator = new AddCoordinator(library);

            } else if (userChoice.equals("2")) {
               coordinator = new DeleteCoordinator(library);
                
            } else if (userChoice.equals("3")) {
                coordinator = new SearchCoordinator(library);
                
            } else if (userChoice.equals("4")) {
               coordinator = new ModifyCoordinator(library); // improve saving single change
               
            } else if (userChoice.equals("5")) {
               coordinator = new ListCoordinator(library); 
                
            } else if (userChoice.equals("6")) {
                moreOperation = false;
            } else
                throw new RuntimeException("Wrong user command: " + userChoice);
            
            coordinator.execute();
            
           
        }
    }
}
