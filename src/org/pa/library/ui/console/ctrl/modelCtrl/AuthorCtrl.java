package org.pa.library.ui.console.ctrl.modelCtrl;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import org.pa.library.model.Author;


public class AuthorCtrl {
    public Author readAuthor() {
        Author author = new Author();
        String fName = readLineFromConsole();
        author.setfName(fName);
        String lName = readLineFromConsole();
        author.setlName(lName);
        return author;
    }
   
}