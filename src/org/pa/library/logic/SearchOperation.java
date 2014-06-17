package org.pa.library.logic;

import java.util.ArrayList;
import java.util.List;
import org.pa.library.model.Author;
import org.pa.library.model.Book;
import org.pa.library.model.Library;

public class SearchOperation {
   
    public List<Book> searchTitle(Library library, String title) {
        List<Book> booksByTitle = new ArrayList<Book>();
        for (Book book : library.getBooks()) {
            boolean titleMatch = book.getTitle().equals(title);
            if (titleMatch) {
                booksByTitle.add(book);
            }
        }
        return booksByTitle;
    }

    public List<Book> searchLanguage(Library library, String language) {
        List<Book> booksByLanguage = new ArrayList<Book>();
        for (Book book : library.getBooks()) {
            boolean languageMatch = book.getLanguage().equals(language);
            if (languageMatch) {
                booksByLanguage.add(book);
            }
        }
        return booksByLanguage;
    }

    public List<Book> searchYearOfIssuing(Library library, int yearOfIssuing) {
        List<Book> booksByYearOfIssuing = new ArrayList<Book>();
        for (Book book : library.getBooks()) {

            boolean yearOfIssuingMatch = book.getYearOfIssuing().equals(yearOfIssuing);
            if (yearOfIssuingMatch) {
                booksByYearOfIssuing.add(book);
                }
        }
        return booksByYearOfIssuing;
    }

    public List<Book> searchAuthor(Library library, List<Author> authors) {
        List<Book> booksByAuthor = new ArrayList<Book>();
        for (Book book : library.getBooks()) {

            boolean authorsMatch = true;
            for (Author authorRequest : authors) {
                boolean requestAuthorMatch = false;
                for (Author author : book.getAuthors()) {

                    boolean authorMatch = false;
                    boolean fNameMatch = author.getfName().equals(authorRequest.getfName());
                    boolean lNameMatch = author.getlName().equals(authorRequest.getlName());

                    authorMatch = fNameMatch && lNameMatch;
                    if (authorMatch) {
                        requestAuthorMatch = true;
                        break;
                    }
                }
                if (!requestAuthorMatch) {
                    authorsMatch = false;
                    break;
                }
            }
            if (authorsMatch)
                booksByAuthor.add(book);
        }
        return booksByAuthor;
    }    
}
