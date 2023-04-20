package com.reactivetest.r2db.personDomain;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;


public interface PersonRepository extends ReactiveSortingRepository<Person, String>{
    Flux<Person> findAll();

    Flux<Person> findByLastNm();
}
