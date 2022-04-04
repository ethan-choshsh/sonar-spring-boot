package com.choshsh.sonar.sonar.api;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class HelloController {

    @GetMapping("/hello")
    Flux<String> hello() {
        return Flux.just("Hello", "World");
    }

    @GetMapping("/user")
    ResponseEntity<Person> test() {
        Person person = new Person();
        person.setName("ethan");
        person.setFavoriteFood("햄버거");

        return new ResponseEntity<>(person, null, HttpStatus.OK);
    }

    @Data
    static class Person {
        String name;
        String favoriteFood;
    }
}
