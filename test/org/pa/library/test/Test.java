package org.pa.library.test;

import org.pa.library.model.Library;
import org.pa.library.model.Author;
import org.pa.library.model.Book;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Test of PA's library management system.\n");
		
		Book book1 = new Book();
		book1.setTitle("Cooking for babies");
		book1.setDescription("Recomended book for every mum.");
		book1.setSignature("AC12345");
		
		Author author1 = new Author();
		book1.getAuthors().add(author1);
		author1.setfName("Phuong Anh");
		author1.setlName("Vu");
		author1.setBio("Eperienced baby carer");
		
		String language1 = "Vietnamese";
				
		book1.setLanguage(language1);
		
		
		Book book2 = new Book();
		book2.setTitle("Cooking for babies");
		book2.setDescription("Recomended book for every mum.");
		book2.setSignature("AC12346");
		
	
		book2.getAuthors().add(author1);
		
		String language2 = "English";
				
		book2.setLanguage(language2);
		
		Book book3 = new Book ();
		book3.setTitle ("Baking.");
		book3.setDescription ("For both beginners and prof.");
		book3.setSignature ("AC12347");
		
		Author author2 = new Author();
		author2.setfName ("Andrzej");
		author2.setlName ("Sekula");
		author2.setBio ("Unexperienced dad.");
		book3.getAuthors().add(author2);
		
			
		book3.setLanguage (language2);
	}	
	
/*		String book1Info = book1.getInfo(); // comment out to see if Book.getInfo() is needed -> Result: not needed
		System.out.println(book1Info);
		System.out.println();
		
		String book2Info = book2.getInfo();
		System.out.println(book2Info);
		System.out.println ();
		
		String book3Info = book3.getInfo();
		System.out.println (book3Info);
	}

*/	
	public void test1() {
		Library library = new Library();
		
/*		String signature = library.addBook("author", "title", "language");
		library.deleteBook(signature);
		library.borrowBook(signature, reader);
		library.returnBook(signature, reader);
		
		List<Reader> lateReaders = library.findAllLateReaders();
		library.banReader(reader);*/
	}

}


/*

TODO:

+enter books in loop
+show new books in debugger
ask user about when to stop entering of books - PA
dump books to a file

different constructors, parameters

*/