package com.pturo.lib.api;

import com.pturo.lib.model.Book;
import com.pturo.lib.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class LibApi {
    private LibService libService;

    @Autowired
    public LibApi(LibService libService) {
        this.libService = libService;
    }
    
    @GetMapping("/all")
    public Iterable<Book> findAll() {
        return libService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@RequestParam Long id) {
        return libService.findById(id);
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return libService.save(book);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        return libService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@RequestParam Long id) {
        libService.deleteById(id);
    }
}
