package com.reactivetest.r2db.testService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reactivetest.r2db.personDomain.Person;
import com.reactivetest.r2db.personDomain.PersonDto;
import com.reactivetest.r2db.personDomain.PersonRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class TestService {

    private final PersonRepository personRepository;

    public Flux<Void> insertTest(PersonDto person){

        Person personEntity = new Person();
        BeanUtils.copyProperties(person, personEntity);
        personRepository.save(personEntity);

        return Flux.empty();

    }

    // public Flux<Void> insertTest2(PersonDto person){

    //     return Flux.just("").flatMap(() ->
    //     {
    //         Person personEntity = new Person();
    //         BeanUtils.copyProperties(person, personEntity);
    //         personRepository.save(personEntity);
    //         return "";
            
    //     });

    // }

    public Flux<Person> readTest(String lastNm){

        return personRepository.findByLastNm();
        
    }

    public void updateTest(PersonDto person){
        


    }

    public void deleteTest(){
        
    }
    
}
