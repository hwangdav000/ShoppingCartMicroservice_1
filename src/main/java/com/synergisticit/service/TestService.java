package com.synergisticit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	private static List<String> bookList = Arrays.asList("Book1","Book2","Book3");
	
	    public static List<String> getBookList() {
	        return bookList;
	    }
}
