package com.booksApi.Books.service;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.booksApi.Books.entity.Book;
import com.booksApi.Books.repository.BookRepository;

import java.io.InputStream;

@Service
public class ExcelService {

    @Autowired
    private BookRepository bookRepository;

    public void importBooksFromExcel(MultipartFile file) {
        try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0); // Read the first sheet

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    // Skip the header row
                    continue;
                }

                Book book = new Book();
                book.setIsbn(row.getCell(0).getStringCellValue());
                book.setTitle(row.getCell(1).getStringCellValue());
                book.setAuthor(row.getCell(2).getStringCellValue());
                book.setYearOfPublication((int) row.getCell(3).getNumericCellValue());
                book.setPublisher(row.getCell(4).getStringCellValue());

                // Save the book to the database
                bookRepository.save(book);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to import data: " + e.getMessage(), e);
        }
    }

}
