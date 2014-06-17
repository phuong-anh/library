package org.pa.library.ui.console.ctrl.functionCtrl;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import java.util.List;
import org.pa.library.model.Author;
import org.pa.library.model.Book;
import org.pa.library.ui.console.ctrl.modelCtrl.AuthorCtrl;
import org.pa.library.ui.console.ctrl.modelCtrl.LanguageCtrl;
import org.pa.library.ui.console.ctrl.modelCtrl.TitleCtrl;
import org.pa.library.ui.console.ctrl.modelCtrl.YearOfIssueCtrl;
import org.pa.library.ui.console.viewer.modelViewers.AuthorViewer;
import org.pa.library.ui.console.viewer.modelViewers.LanguageViewer;
import org.pa.library.ui.console.viewer.modelViewers.TitleViewer;
import org.pa.library.ui.console.viewer.modelViewers.YearOfIssueViewer;

public class AddCtrl {
    private AuthorViewer authorViewer = new AuthorViewer();
    private TitleViewer titleViewer = new TitleViewer();
    private LanguageViewer languageViewer = new LanguageViewer();
    private YearOfIssueViewer yearOfIssueViewer = new YearOfIssueViewer();
    private AuthorCtrl authorCtrl = new AuthorCtrl();
    private TitleCtrl titleCtrl = new TitleCtrl();
    private LanguageCtrl languageCtrl = new LanguageCtrl();
    private YearOfIssueCtrl yearOfIssueCtrl = new YearOfIssueCtrl();

    public Book enterBook() {
        Book book = new Book();
        fillBookData(book);
        addAuthors(book);

        return book;

    }

    private void fillBookData(Book book) {
        titleViewer.makeTitleViewer();
        titleCtrl.readTitle(book);
        languageViewer.makeLanguageViewer();
        languageCtrl.readLanguage(book);
        yearOfIssueViewer.makeYearOfIssueViewer();
        yearOfIssueCtrl.readYearOfIssue(book);
    }

    private void addAuthors(Book book) {
        boolean moreAuthor = true;
        while (moreAuthor) {
            List<Author> authors = book.getAuthors();
            Author author = new Author();
            authorViewer.makeAuthorViewer();
            author = authorCtrl.readAuthor();
            authors.add(author);
            book.setAuthors(authors);

            authorViewer.askAuthorMore();
            String answer = readLineFromConsole();
            if (answer.equals("no"))
                moreAuthor = false;
        }
    }
}