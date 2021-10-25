package com.bizzinali.springbootwebapp.repositories;

import com.bizzinali.springbootwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
