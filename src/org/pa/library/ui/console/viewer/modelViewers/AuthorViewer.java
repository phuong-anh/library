package org.pa.library.ui.console.viewer.modelViewers;

import static org.pa.library.ui.console.helper.ConsoleHelper.writeLn;

public class AuthorViewer {
    public void makeAuthorViewer(){
        writeLn("author first name: ");
        writeLn("author last name: ");
        }
    public void askAuthorMore(){
        writeLn("Do you want to enter more authors? yes/no");
    }
}
