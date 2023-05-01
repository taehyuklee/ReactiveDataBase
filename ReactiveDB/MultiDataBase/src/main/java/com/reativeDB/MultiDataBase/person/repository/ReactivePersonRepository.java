package com.reativeDB.MultiDataBase.person.repository;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import com.reativeDB.MultiDataBase.person.Person;

import reactor.core.publisher.Flux;

public interface ReactivePersonRepository extends ReactiveSortingRepository<Person, String>{
    Flux<Person> findByLastNm(String lastNm);
}
