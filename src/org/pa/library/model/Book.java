package org.pa.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Book {
	private String title;
	private String description;
	private String signature;
	private Integer yearOfIssuing;
	
	private List<Author> authors;
	private String language;
	
	private List<Borrowing> borrowings;
	
	public Book(){
		authors = new ArrayList<Author>();
	}
	
	public String authorsInfo() {
		String authorsInfo = "";
		for (Author author : authors) {
			if (author != authors.get(authors.size()-1)) {
				authorsInfo = authorsInfo + author.getInfo() +", ";
			}
			else authorsInfo = authorsInfo + author.getInfo();// delete + "."
		}
		return authorsInfo;	
	}
	
	@XmlElement
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public Integer getYearOfIssuing() {
		return yearOfIssuing;
	}
	public void setYearOfIssuing(Integer yearOfIssuing) {
		this.yearOfIssuing = yearOfIssuing;
	}
	@XmlElement
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	@XmlAttribute
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@XmlElement
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<Borrowing> getBorrowings() {
		return borrowings;
	}

	public void setBorrowings(List<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}
}
