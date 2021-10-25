package com.bizzinali.springbootwebapp.repositories;

import com.bizzinali.springbootwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
