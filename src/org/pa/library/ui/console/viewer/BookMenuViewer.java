package org.pa.library.ui.console.viewer;

import static org.pa.library.ui.console.helper.ConsoleHelper.writeLn;

public class BookMenuViewer {  
    public void showMenu() {  //AS refactor by adding description to the Oeration constructor (not important)
        writeLn("Press 1: Enter a book.");
        writeLn("Press 2: Delete a book.");
        writeLn("Press 3: Search a book.");
        writeLn("Press 4: Modify book data.");
        writeLn("Press 5: List all books.");
        writeLn("Press 6: Exit.");
    }
    public void answerKeyIncorrect() {
        writeLn("Incorrect key. Please choose 1, 2, 3, 4, 5, or 6.");
    }
}
