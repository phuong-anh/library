package org.pa.library.ui.console.ctrl.functionCtrl;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import org.pa.library.model.Author;
import org.pa.library.model.Book;
import org.pa.library.ui.console.ctrl.modelCtrl.AuthorCtrl;
import org.pa.library.ui.console.ctrl.modelCtrl.LanguageCtrl;
import org.pa.library.ui.console.ctrl.modelCtrl.TitleCtrl;
import org.pa.library.ui.console.ctrl.modelCtrl.YearOfIssueCtrl;
import org.pa.library.ui.console.viewer.modelViewers.AuthorViewer;
import org.pa.library.ui.console.viewer.modelViewers.LanguageViewer;
import org.pa.library.ui.console.viewer.functionViewers.SearchMenuViewer;
import org.pa.library.ui.console.viewer.modelViewers.TitleViewer;
import org.pa.library.ui.console.viewer.modelViewers.YearOfIssueViewer;

public class BookRequest {
    private SearchMenuViewer searchMenuViewer   = new SearchMenuViewer();
    private TitleViewer titleViewer             = new TitleViewer();
    private TitleCtrl titleCtrl                 = new TitleCtrl();
    private LanguageViewer languageViewer       = new LanguageViewer();
    private LanguageCtrl languageCtrl           = new LanguageCtrl();
    private YearOfIssueViewer yearOfIssueViewer = new YearOfIssueViewer();
    private YearOfIssueCtrl yearOfIssueCtrl     = new YearOfIssueCtrl();
    private AuthorViewer authorViewer           = new AuthorViewer();
    private AuthorCtrl authorCtrl               = new AuthorCtrl();

    public Book receiveRequest() { 
        Book request = new Book();        

        boolean moreKeyword = true;
        while (moreKeyword) {
            searchMenuViewer.makeSearchMenu();
            String keyword = readLineFromConsole();
            if (keyword.equals("title")) {
                titleViewer.makeTitleViewer();
                titleCtrl.readTitle(request);
            } else if (keyword.equals("author")) {
                boolean moreAuthorRequest = true;
                while (moreAuthorRequest) {
                    authorViewer.makeAuthorViewer();
                    Author author = authorCtrl.readAuthor();
                    request.getAuthors().add(author);
                    authorViewer.askAuthorMore();
                    String answer = readLineFromConsole();
                    if (answer.equals("no")) {
                        moreAuthorRequest = false;
                    }
                }
            } else if (keyword.equals("language")) {
                languageViewer.makeLanguageViewer();
                languageCtrl.readLanguage(request);
                
            } else if (keyword.equals("year_of_issuing")) {
                yearOfIssueViewer.makeYearOfIssueViewer();
                yearOfIssueCtrl.readYearOfIssue(request);
            } else
                searchMenuViewer.answerSearchKeyWordFail();

            searchMenuViewer.askMoreSearchKeyword();
            String answer = readLineFromConsole();
            if (answer.equals("no")) {
                moreKeyword = false;
            }
        }
        return request;
    }

}
