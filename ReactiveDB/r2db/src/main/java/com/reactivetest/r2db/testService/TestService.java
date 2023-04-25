package com.reactivetest.r2db.testService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reactivetest.r2db.personDomain.Person;
import com.reactivetest.r2db.personDomain.PersonDto;
import com.reactivetest.r2db.personDomain.PersonRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final PersonRepository personRepository;

    public Mono<String> insertTest(PersonDto person){

        Person personEntity = new Person();
        BeanUtils.copyProperties(person, personEntity);
        Mono<Person> result = personRepository.save(personEntity);

        log.info("Insertion");

        return result.map(p -> {
            System.out.println(p);
            return "Success";
        
        });
    }


    public Flux<Person> readTest(String lastNm){


        // BeanUtils.copyProperties(person, personEntity);
        Flux<Person> result = personRepository.findByLastNm(lastNm);

        log.info("Insertion");

        return result;
        
    }

    public void updateTest(PersonDto person){
        


    }

    public void deleteTest(){
        
    }
    
}
