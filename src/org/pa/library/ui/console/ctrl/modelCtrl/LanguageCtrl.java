package org.pa.library.ui.console.ctrl.modelCtrl;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import org.pa.library.model.Book;


public class LanguageCtrl {
    public void readLanguage(Book book) {
        String language = readLineFromConsole();
        book.setLanguage(language);
    }
}