package org.pa.library.ui.console.ctrl;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import org.pa.library.ui.console.viewer.BookMenuViewer;

public class BookMenuCtrl { 

    public String readUserChoice(BookMenuViewer bookMenuViewer) {
        String userChoice = readLineFromConsole();
         boolean isCorrect = validate(userChoice);
        if (!isCorrect) {
           bookMenuViewer.answerKeyIncorrect();
           userChoice = null;
        }
        return userChoice;
    }
    
    private boolean validate(String userChoice) {
        boolean isCorrect = userChoice.equals("1") || userChoice.equals("2") || userChoice.equals("3") || userChoice.equals("4")
        || userChoice.equals("5") || userChoice.equals("6");
        return isCorrect;
    }
   
}
