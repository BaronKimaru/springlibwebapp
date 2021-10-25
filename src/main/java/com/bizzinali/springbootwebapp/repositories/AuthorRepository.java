package com.bizzinali.springbootwebapp.repositories;

import com.bizzinali.springbootwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
