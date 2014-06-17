package org.pa.library.ui.console.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ConsoleHelper {
	
	public static void writeLn(String text) {
		System.out.println(text);
	}
	
	public static void write(String text) {
		System.out.print(text);
	}
	
	public static String readLineFromConsole() {
		 try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String line = bufferRead.readLine();
			return line;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
