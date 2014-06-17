package org.pa.library.ui.console.viewer.functionViewers;

import static org.pa.library.ui.console.helper.ConsoleHelper.writeLn;

public class AuthorModifyViewer {// call by ModifyController
    
    public void askAuthorModifyIndex() {
        writeLn("Enter author index for modifying.");
    }

    public void makeAuthorModifyViewer() {
        writeLn("New first name");
        writeLn("New last name");
    }

    public void askAuthorModifyDelete() {
        writeLn("Do you want to delete author? yes/no ");
    }

    public void askAuthorModifyAdd() {
        writeLn("Do you want to add author? yes/no ");
    }

    public void askAuthorModifyMore() {
        writeLn("Do you want to modify more authors? yes/no");
    }

}
