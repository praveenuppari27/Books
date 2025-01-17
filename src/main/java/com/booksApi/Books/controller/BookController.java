package com.booksApi.Books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.booksApi.Books.service.ExcelService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private ExcelService excelservice;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is missing!");
        }
        // Call the service to process the file
        try {
            excelservice.importBooksFromExcel(file);
            return ResponseEntity.ok("File uploaded and data imported successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
    
    @GetMapping("/123")
    public String sayHello() {
        return "Hello, World!";
    }
}

