package com.example.project.classes;

public class PageCounter {

	
	public Integer pageCounter=0;
	
	public PageCounter() {
		
	}
	
	public void incrementPageCounter() {
		this.pageCounter++;
	}
	
	public Integer getCurrentPageCount() {
		return this.pageCounter;
	}
}
