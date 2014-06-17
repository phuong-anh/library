package org.pa.library.ui.console.ctrl.functionCtrl;

import static org.pa.library.dao.XMLHelper.writeToXML;
import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import org.pa.library.logic.ModifyOperation;
import org.pa.library.model.Author;
import org.pa.library.model.Book;
import org.pa.library.model.Library;
import org.pa.library.ui.console.ctrl.modelCtrl.AuthorCtrl;
import org.pa.library.ui.console.viewer.functionViewers.AuthorModifyViewer;
import org.pa.library.ui.console.viewer.modelViewers.AuthorViewer;
import org.pa.library.ui.console.viewer.functionViewers.BookManageViewer;
import org.pa.library.ui.console.viewer.functionViewers.BookToModifyViewer;

public class ModifyCtrl {// problem with library = null
    public ModifyCtrl(Library library) {
        this.library = library;
    }

    private Library library;
    private BookToModifyViewer bookToModifyViewer = new BookToModifyViewer();
    private BookManageViewer bookManageViewer = new BookManageViewer();
    private AuthorModifyViewer authorModifyViewer = new AuthorModifyViewer();
    private AuthorViewer authorViewer = new AuthorViewer();
    private AuthorCtrl authorCtrl = new AuthorCtrl();
    private ModifyOperation modifyOperation = new ModifyOperation();

    public String readTitleModifyViewer() {
        String newTitle = readLineFromConsole();
        return newTitle;
    }

    public String readLanguageModifyViewer() {
        String newLanguage = readLineFromConsole();
        return newLanguage;
    }

    public String readYearOfIssuingModifyViewer() {
        String newYearOfIssuingS = readLineFromConsole();
        return newYearOfIssuingS;
    }

    public void modifyAuthor(Book bookToModify) {

        boolean moreAuthorModify = true;
        while (moreAuthorModify) {
            int indexAuthor = getAuthorIndex();
            boolean indexCorrect = validateIndexAuthor(bookToModify, indexAuthor);
            if (indexCorrect) {
                authorModifyViewer.makeAuthorModifyViewer();
                String newfName = readLineFromConsole();
                if (!newfName.equals("")) {
                    modifyOperation.modifyAuthorfName(bookToModify, indexAuthor, newfName);
                }
                String newlName = readLineFromConsole();
                if (!newlName.equals("")) {
                    modifyOperation.modifyAuthorlName(bookToModify, indexAuthor, newlName);
                }

                chooseToDeleteAuthor(bookToModify, indexAuthor);
                chooseToAddAuthor(bookToModify);

            } else
                bookManageViewer.answerIndexFail();

            authorModifyViewer.askAuthorModifyMore();
            String answer = readLineFromConsole();
            if (answer.equals("no")) {
                moreAuthorModify = false;
            }
        }

    }

    private boolean validateIndexAuthor(Book bookToModify, int indexAuthor) {
        boolean indexCorrect = indexAuthor <= modifyOperation.getBookToModify(bookToModify).getAuthors().size() && indexAuthor >= 0;
        return indexCorrect;
    }

    private void chooseToDeleteAuthor(Book bookToModify, int indexAuthor) {
        authorModifyViewer.askAuthorModifyDelete();
        String answerDelete = readLineFromConsole();
        boolean wantDelete = answerDelete.equals("yes");
        if (wantDelete) {
            modifyOperation.deleteAuthor(bookToModify, indexAuthor);
        }
    }

    private void chooseToAddAuthor(Book bookToModify) {
        authorModifyViewer.askAuthorModifyAdd();
        String answerAdd = readLineFromConsole();
        boolean wantAdd = answerAdd.equals("yes");
        if (wantAdd) {
            Author newAuthor = new Author();
            authorViewer.makeAuthorViewer();
            newAuthor = authorCtrl.readAuthor();
            modifyOperation.addAuthor(bookToModify, newAuthor);
        }
    }

    private int getAuthorIndex() {
        authorModifyViewer.askAuthorModifyIndex();
        String indexAuthorS = readLineFromConsole();
        int indexAuthor = Integer.parseInt(indexAuthorS);
        indexAuthor = indexAuthor - 1;
        return indexAuthor;
    }

    public Book executeModifyChoice(Book bookToModify) {
        
        boolean moreKeyword = true;
        while (moreKeyword) {
            bookToModifyViewer.makeModifyMenu();
            String keyword = readLineFromConsole();
            if (keyword.equals("title")) {
                bookToModifyViewer.makeTitleModifyViewer();
                String newTitle = readTitleModifyViewer();
                if (!newTitle.equals("")) {
                    modifyOperation.modifyTitle(bookToModify, newTitle);
                }
            } else if (keyword.equals("language")) {
                bookToModifyViewer.makeLanguageModifyViewer();
                String newLanguage = readLanguageModifyViewer();
                if (!newLanguage.equals("")) {
                    modifyOperation.modifyLanguage(bookToModify, newLanguage);
                }
            } else if (keyword.equals("year_of_issuing")) {
                bookToModifyViewer.makeYearOfIssuingModifyViewer();
                String newYearOfIssuingS = readYearOfIssuingModifyViewer();
                if (!newYearOfIssuingS.equals("")) {
                    int newYearOfIssuing = Integer.parseInt(newYearOfIssuingS);
                    modifyOperation.modifyYearOfIssuing(bookToModify, newYearOfIssuing);
                }
            } else if (keyword.equals("author")) {
                modifyAuthor(bookToModify);
            }

            writeToXML(library);// save to disc after each book's modification,
                                // not after every single modification to book,
                                // as i had problem with deleting database when
                                // saving was in ModifyOperation.

            bookToModifyViewer.askMoreKeywordToModify();
            String answerMoreKeywordToModify = readLineFromConsole();
            if (answerMoreKeywordToModify.equals("no"))
                moreKeyword = false;
        }
        Book modifiedBook = bookToModify;

        return modifiedBook;
    }

}
