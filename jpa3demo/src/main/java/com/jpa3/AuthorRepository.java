package com.jpa3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {



}

