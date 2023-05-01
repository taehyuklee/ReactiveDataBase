package com.reativeDB.MultiDataBase.person;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface PersonRepository{

    Flux<Person> findByLastNm(String lastNm);
}
