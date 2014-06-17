package org.pa.library.logic;

import org.pa.library.model.Author;
import org.pa.library.model.Book;

public class ModifyOperation {
      
     public Book getBookToModify(Book bookToModify) {// use in
                                                    // ModifyController.readAuthorModifyViewer()

        return bookToModify;
    }

    public void modifyTitle(Book bookToModify, String newTitle) {
        bookToModify.setTitle(newTitle);
   
    }

    public void modifyLanguage(Book bookToModify, String newLanguage) {
        bookToModify.setLanguage(newLanguage);
      
    }

    public void modifyYearOfIssuing(Book bookToModify, int newYearOfIssuing) {
        bookToModify.setYearOfIssuing(newYearOfIssuing);
       
    }

    public void modifyAuthorfName(Book bookToModify, int indexAuthor, String newfName) {

        bookToModify.getAuthors().get(indexAuthor).setfName(newfName);
  
    }

    public void modifyAuthorlName(Book bookToModify, int indexAuthor, String newlName) {

        bookToModify.getAuthors().get(indexAuthor).setlName(newlName);
      
    }

    public void deleteAuthor(Book bookToModify, int indexAuthor) {
        bookToModify.getAuthors().remove(indexAuthor);
      
    }

    public void addAuthor(Book bookToModify, Author newAuthor) {
        bookToModify.getAuthors().add(newAuthor);
      
    }

}