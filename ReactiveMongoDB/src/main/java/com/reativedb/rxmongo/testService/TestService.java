package com.reativedb.rxmongo.testService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reativedb.rxmongo.person.Person;
import com.reativedb.rxmongo.person.PersonDto;
import com.reativedb.rxmongo.person.repository.ReactivePersonRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final ReactivePersonRepository personRepository;

    // @Transactional
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

    // @Transactional
    public Mono<String> insertScore(){

        Mono<String> result = Mono.just("").doOnNext((i)-> {

        });


        return result;
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
