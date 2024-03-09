package ch12.generics.extra.util;

import java.util.List;

import ch12.generics.extra.model.Student;

import java.util.ArrayList;

public class QueryList <T extends Student & QueryItem> {

	// Main method is in ch12.generics.extra

	private List<T> items;
	public QueryList(List<T> items) {
		this.items = items;
		
	}
	
	public static <S extends QueryItem> List<S> getMatches(List<S> items, String field, String value){
		
		List<S> matches = new ArrayList<>();
		for(var item : items) {
			if(item.matchFieldValue(field, value)) {
				matches.add(item);
			}
		}
		return matches;
	}
	
	
	public List<T> getMatches(String field, String value){
		
		List<T> matches = new ArrayList<>();
		for(var item : items) {
			if(item.matchFieldValue(field, value)) {
				matches.add(item);
			}
		}
		return matches;
	}
	
	
}
