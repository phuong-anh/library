package org.pa.library.ui.console.ctrl.functionCtrl;

import java.util.ArrayList;
import java.util.List;
import org.pa.library.logic.SearchOperation;
import org.pa.library.model.Book;
import org.pa.library.model.Library;
import org.pa.library.ui.console.viewer.functionViewers.BookListViewer;
import org.pa.library.ui.console.viewer.functionViewers.BookManageViewer;
import org.pa.library.ui.console.viewer.functionViewers.BookManageViewer;
import org.pa.library.ui.console.viewer.functionViewers.SearchMenuViewer;
public class SearchCtrl {
    private SearchOperation searchOperation   = new SearchOperation();
    private BookManageViewer bookManageViewer = new BookManageViewer();
    private SearchMenuViewer searchMenuViewer = new SearchMenuViewer();   
    private BookListViewer bookListViewer     = new BookListViewer();
    // put library in constructor.
  
    public List<Book> searchBook(Library library, Book request) {// don't know how to extract this method to search Operation leaving out the requestFail exception.
        
        List<Book> foundBooks = new ArrayList<Book>();       
        List<Book> booksByTitle = new ArrayList<Book>();
        List<Book> booksByLanguage = new ArrayList<Book>();
        List<Book> booksByYearOfIssuing = new ArrayList<Book>();
        List<Book> booksByAuthor = new ArrayList<Book>();
        boolean emptyTitle = request.getTitle() == null;
        boolean emptyLanguage = request.getLanguage() == null;
        boolean emptyYearOfIssuing = request.getYearOfIssuing() == null;
        boolean emptyAuthor = request.getAuthors().size() == 0;
        
        List<ArrayList<Book>> list = new ArrayList<ArrayList<Book>>();
        
        if(!emptyTitle) {        
        booksByTitle = searchOperation.searchTitle(library, request.getTitle());
        }
        if(!emptyLanguage) {        
        booksByLanguage = searchOperation.searchLanguage(library, request.getLanguage());
        }
        if(!emptyYearOfIssuing) {        
        booksByYearOfIssuing = searchOperation.searchYearOfIssuing(library, request.getYearOfIssuing());
        }
        if(!emptyAuthor) {        
        booksByAuthor = searchOperation.searchAuthor(library, request.getAuthors());
        }
        // make a list of non-empty lists 
        if (booksByTitle.size() != 0) {
            list.add((ArrayList<Book>) booksByTitle);
        }
        if (booksByLanguage.size() != 0) {
            list.add((ArrayList<Book>) booksByLanguage);            
        }
        if (booksByYearOfIssuing.size() != 0) {
            list.add((ArrayList<Book>) booksByYearOfIssuing);
        }
        if (booksByAuthor.size() != 0) {
            list.add((ArrayList<Book>) booksByAuthor);
        }
          // pick the first list in the list<List>, call retainAll from this list on all of the lists   
        for(ArrayList<Book> arrayList : list) {      
        list.get(0).retainAll(arrayList);
        }
      //filter out the common items from the 4 lists  
          foundBooks = list.get(0);   
                
        if (emptyTitle && emptyLanguage && emptyYearOfIssuing && emptyAuthor) {
            bookManageViewer.answerBookRequestFail();
            searchMenuViewer.makeSearchMenu();
        }
        return foundBooks;

    }
               
   public void showFoundBooks(Library library, List<Book> foundBooks) { 
       
        if (foundBooks.size() == 0) {
                bookManageViewer.answerBookSearchFail();
            }
           else bookListViewer.listFoundBooks(foundBooks);
            
        }   
}
