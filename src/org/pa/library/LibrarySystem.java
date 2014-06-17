package org.pa.library;
import org.pa.library.ui.console.coordinator.BookMenuCoordinator;

public class LibrarySystem {
	
	public static void main(String[] args){
		System.out.println("Welcome to PA's library management system.\n");
		BookMenuCoordinator bookMenuCoordinator = new BookMenuCoordinator(); 
		
		bookMenuCoordinator.runLibrary();
		}
	}


