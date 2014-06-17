package org.pa.library.ui.console.viewer.functionViewers;

import static org.pa.library.ui.console.helper.ConsoleHelper.writeLn;

import org.pa.library.model.Book;

public class BookToModifyViewer {

public void askForIndexBookToModify(){// call by Controller
    writeLn("Enter book index for modifying.");
}

public void showBookToModify(Book bookToModify){// call by Controller
    writeLn(bookToModify.getTitle() + " by " + ""
            + bookToModify.authorsInfo() + ", " 
            + bookToModify.getLanguage() + ", " + bookToModify.getYearOfIssuing() + ".");
}

public void makeModifyMenu(){
    writeLn("Enter keyword for modifying: title, author, language, or year_of_issuing.");
}

public void makeTitleModifyViewer(){
    writeLn("New title");
}

public void makeLanguageModifyViewer(){
    writeLn("New language");
}

public void makeYearOfIssuingModifyViewer(){
    writeLn("New year of issuing");
}

public void showModifiedBook(Book bookToModify){
    writeLn("Modified book: " + bookToModify.getTitle() + " by " + "" + bookToModify.authorsInfo() + ", " 
            + bookToModify.getLanguage() + ", " + bookToModify.getYearOfIssuing() + ".");
}

public void askMoreBookToModify(){
    writeLn("Do you want to modify more books? yes/no");
}

public void askMoreKeywordToModify(){
    writeLn("Do you want to enter more keyword for modifying? yes/no");
}

}
