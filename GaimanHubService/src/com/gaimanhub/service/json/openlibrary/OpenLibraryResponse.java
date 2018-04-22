package com.gaimanhub.service.json.openlibrary;

import java.util.List;

public class OpenLibraryResponse {
	private int start;
	private int num_found;
	private int numFound;
	private List<OpenLibraryBook> docs;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getNum_found() {
		return num_found;
	}
	public void setNum_found(int num_found) {
		this.num_found = num_found;
	}
	public int getNumFound() {
		return numFound;
	}
	public void setNumFound(int numFound) {
		this.numFound = numFound;
	}
	public List<OpenLibraryBook> getDocs() {
		return docs;
	}
	public void setDocs(List<OpenLibraryBook> docs) {
		this.docs = docs;
	}
	
}
