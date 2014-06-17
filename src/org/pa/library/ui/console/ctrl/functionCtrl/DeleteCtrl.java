package org.pa.library.ui.console.ctrl.functionCtrl;

import static org.pa.library.ui.console.helper.ConsoleHelper.readLineFromConsole;
//Viewer in BookManageViewer
public class DeleteCtrl {
    public int getIndexDelete(){            
        String indexS = readLineFromConsole();
        int index = Integer.parseInt(indexS);
        index--;
        return index;
    }
}
