package org.pa.library.ui.console.viewer.functionViewers;

public class SearchMenuViewer {
   public void makeSearchMenu(){
    System.out.println("Please choose keyword for searching: title, author, language or year_of_issuing");
  }
   public void askMoreSearchKeyword(){
       System.out.println("Do you want to enter more keyword for searching? yes/no");
   }
   public void answerSearchKeyWordFail() {
       System.out.println("Wrong keyword for searching.");
   }
}
