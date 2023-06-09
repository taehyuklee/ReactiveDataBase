package com.reactivetest.r2db.testService;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reactivetest.r2db.person.Person;
import com.reactivetest.r2db.person.PersonDto;
import com.reactivetest.r2db.person.PersonRepository;
import com.reactivetest.r2db.person.repository.ReactivePersonRepository;
import com.reactivetest.r2db.scores.ScoreRepository;
import com.reactivetest.r2db.scores.Scores;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final ReactivePersonRepository personRepository;
    private final ScoreRepository scoreRepository;

    // @Transactional
    public Mono<String> insertTest(PersonDto person){

        Person personEntity = new Person();
        BeanUtils.copyProperties(person, personEntity);
        Mono<Person> result = personRepository.save(personEntity);

        // //일반 JPA
        // Scores scores = new Scores();
        // scores.setScore((int) Math.random()*100);
        // scoreRepository.save(scores);

        log.info("Insertion");

        return result.map(p -> {
            System.out.println(p);
            return "Success";
        
        });
    }

    // @Transactional
    public Mono<String> insertScore(){

        Mono<String> result = Mono.just("").doOnNext((i)-> {

            //일반 JPA
            Scores scores = new Scores();
            scores.setScore((int) Math.random()*100);
            String uuId =UUID.randomUUID().toString();
            scores.setId(uuId);
            scoreRepository.save(scores);

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
