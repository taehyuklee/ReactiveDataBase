package com.reativedb.multidb.person.repository;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import com.reativedb.multidb.person.Person;

import reactor.core.publisher.Flux;

public interface ReactivePersonRepository extends ReactiveSortingRepository<Person, String>{
    Flux<Person> findByLastNm(String lastNm);
}
