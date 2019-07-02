package com.jialing.swift.flux.config;


import com.jialing.swift.flux.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;


@Configuration
public class PersonConfig {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionPerson() {
        Person p = new Person();
        p.setId(2);
        p.setName("李四");
        Flux<Person> personFlux = Flux.just(p);
        return RouterFunctions.route(RequestPredicates.path("/hello/webflux/index"), request ->ServerResponse.ok().body(personFlux, Person.class));
    }

}
