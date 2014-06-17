package org.pa.library.ui.console.ctrl.modelCtrl;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import org.pa.library.model.Book;


public class TitleCtrl {
    public void readTitle(Book book) {//use Book, not DTO here because this class is also used by AddController
        String title = readLineFromConsole();
        book.setTitle(title);
    }
}
