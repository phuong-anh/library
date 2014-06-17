package org.pa.library.ui.console.viewer.functionViewers;

import static org.pa.library.ui.console.helper.ConsoleHelper.writeLn;

public class BookManageViewer {

public void askMoreBookAdd(){
    writeLn("Do you want to enter more books? yes/no");
}

public void answerBookAddSuccess() {
    writeLn("Book added.");
    }

public void answerBookRequestFail() {
    writeLn("Empty request.");
}

public void answerBookSearchFail() {
    writeLn("Book not found.");
}

public void answerIndexFail() {
    writeLn("Index not found.");
}


}
