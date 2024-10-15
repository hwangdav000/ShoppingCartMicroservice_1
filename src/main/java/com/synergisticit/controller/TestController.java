package com.synergisticit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergisticit.service.TestService;

@RestController
public class TestController {

    @GetMapping("/books")
    public ResponseEntity<List<String>> getBookList(){ 

        return ResponseEntity.ok(TestService.getBookList());    
    }
}