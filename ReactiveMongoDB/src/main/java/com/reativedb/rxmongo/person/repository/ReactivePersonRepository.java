package com.reativedb.rxmongo.person.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.reativedb.rxmongo.person.Person;

import reactor.core.publisher.Flux;

public interface ReactivePersonRepository extends ReactiveMongoRepository<Person, String>{
    Flux<Person> findByLastNm(String lastNm);
}
