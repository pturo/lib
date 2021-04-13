package com.pturo.lib.service;

import com.pturo.lib.model.Book;
import com.pturo.lib.repo.LibRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibService {
    private LibRepo libRepo;

    @Autowired
    public LibService(LibRepo libRepo) {
        this.libRepo = libRepo;
    }

    public Book save(Book book) {
        return libRepo.save(book);
    }

    public Optional<Book> findById(Long id) {
        return libRepo.findById(id);
    }

    public Iterable<Book> findAll() {
        return libRepo.findAll();
    }

    public void deleteById(Long id) {
        libRepo.deleteById(id);
    }

    // initialize database with first few rows
    @EventListener(ApplicationReadyEvent.class)
    public void initDB() {
        save(new Book("Michalski", "Piękne chwile", "psychologiczny"));
        save(new Book("nesTEA", "Z pamiętnika nastolatki", "dramat"));
        save(new Book("OMEGA-3", "Pod prąd", "sci-fi"));
    }
}
