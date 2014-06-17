package org.pa.library.ui.console.viewer.functionViewers;

import java.util.List;

import org.pa.library.model.Book;
import org.pa.library.model.Library;

public class BookListViewer {
   public void listAllBooks(Library library, List<Book> books) { //AS delete it, and use the below one.
        int bookIndex = 0;
        for (Book book : library.getBooks()) {
            bookIndex ++;//?
            System.out.println(bookIndex + ". " + book.getTitle() + " by " + "" + book.authorsInfo() + ", " + book.getLanguage() + ", "
                    + book.getYearOfIssuing() + ".");
        }
    }
   
   public void listNewBooks(List<Book> newBooks) {
       int bookIndex = 0;
       for (Book book : newBooks) {
           bookIndex ++;//?
           System.out.println(bookIndex + ". " + book.getTitle() + " by " + "" + book.authorsInfo() + ", " + book.getLanguage() + ", "
                   + book.getYearOfIssuing() + ".");
}
   }
   
   public void listFoundBooks(List<Book> foundBooks) {  //AS this is EXACTLY the same as the method above :-). Just delete it and use the above one.
       int bookIndex = 0;
       for (Book book : foundBooks) {
           bookIndex ++;//?
           System.out.println(bookIndex + ". " + book.getTitle() + " by " + "" + book.authorsInfo() + ", " + book.getLanguage() + ", "
                   + book.getYearOfIssuing() + ".");
}
   } 
}
