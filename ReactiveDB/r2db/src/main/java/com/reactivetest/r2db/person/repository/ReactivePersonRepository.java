package com.reactivetest.r2db.person.repository;


import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import com.reactivetest.r2db.person.Person;
import com.reactivetest.r2db.person.PersonRepository;

import reactor.core.publisher.Flux;

public interface ReactivePersonRepository extends ReactiveSortingRepository<Person, String>{
    Flux<Person> findByLastNm(String lastNm);
}
