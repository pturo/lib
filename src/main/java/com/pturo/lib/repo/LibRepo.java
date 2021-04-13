package com.pturo.lib.repo;

import com.pturo.lib.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibRepo extends CrudRepository<Book, Long> {
}
