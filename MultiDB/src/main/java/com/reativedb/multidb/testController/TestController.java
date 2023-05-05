package com.reativedb.multidb.testController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reativedb.multidb.person.Person;
import com.reativedb.multidb.person.PersonDto;
import com.reativedb.multidb.testService.TestService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("reactive/db")
public class TestController {

    private final TestService testService;

    //Insert
    @PostMapping("/insert")
    public Mono<Void> insertTest(@RequestBody PersonDto person){
        return testService.insertTest(person).then();
    }

    @PostMapping("/insertScore")
    public Mono<Void> insertScore(){
        return testService.insertScore().then();
    }

    //Read
    @GetMapping("/read")
    public Flux<Person> readTest(@RequestParam String lastNm){
        return testService.readTest(lastNm);
    }

    //Update
    @PutMapping("/update")
    public void updateTest(@RequestBody PersonDto person){
        testService.updateTest(person);
    }

    //Delete
    @DeleteMapping("/delete")
    public void deleteTest(){
        testService.deleteTest();
    }

    
}
