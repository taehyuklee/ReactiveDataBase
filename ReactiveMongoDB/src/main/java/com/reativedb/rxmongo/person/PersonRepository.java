package com.reativedb.rxmongo.person;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface PersonRepository{

    Flux<Person> findByLastNm(String lastNm);
}
