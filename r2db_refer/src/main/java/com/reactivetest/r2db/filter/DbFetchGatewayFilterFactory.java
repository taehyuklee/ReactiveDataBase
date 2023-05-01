// package com.reactivetest.r2db.filter;

// import com.reactivetest.r2db.personDomain.Person;
// import com.reactivetest.r2db.personDomain.PersonRepository;
// import com.reactivetest.r2db.scoresDomain.ScoreRepository;

// import org.springframework.cloud.gateway.filter.GatewayFilter;
// import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
// import org.springframework.http.server.reactive.ServerHttpResponse;
// import org.springframework.stereotype.Component;


// import lombok.extern.slf4j.Slf4j;
// import reactor.core.publisher.Mono;

// @Component
// @Slf4j
// public class DbFetchGatewayFilterFactory extends AbstractGatewayFilterFactory<DbFetchGatewayFilterFactory.Config>{

//     private final PersonRepository personRepository;
//     private final ScoreRepository scoreRepository;

//     public DbFetchGatewayFilterFactory(PersonRepository personRepository, ScoreRepository scoreRepository){
//         super(Config.class);
//         this.personRepository = personRepository;
//         this.scoreRepository = scoreRepository;
//     }

//     @Override
//     public GatewayFilter apply(Config config) {
//         return (exchange, chain) -> {
//             return chain.filter(exchange).then(Mono.defer(() -> {
//                 log.info("start thread");
//                 scoreRepository.findAll().forEach(scores1 -> {
//                     log.info(scores1.toString());
//                 });
//                 return personRepository.findAll()
//                         .doOnNext(p->{
//                             log.info(p.toString());
//                             ServerHttpResponse response = exchange.getResponse();
//                             response.getHeaders().add(p.getFirstName(),p.getLastName());
//                         })
//                         .doOnComplete(()-> log.info("end thread"))
//                         .then()
//                 ;
//                 // try {
//                 //     Thread.sleep(10);
//                 // } catch (InterruptedException e) {
//                 //     e.printStackTrace();
//                 // }
//             }));
//         };
//     }

//     public static class Config {
//     }



// }
