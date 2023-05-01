package com.reactivetest.r2db.person;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface PersonRepository{

    Flux<Person> findByLastNm(String lastNm);
}
