package org.pa.library.ui.console.ctrl.modelCtrl;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
import org.pa.library.model.Book;

public class YearOfIssueCtrl {
    public void readYearOfIssue(Book book) {
        String yearOfIssuingS = readLineFromConsole();
        int yearOfIssuing = Integer.parseInt(yearOfIssuingS);
        book.setYearOfIssuing(yearOfIssuing);
    }
}