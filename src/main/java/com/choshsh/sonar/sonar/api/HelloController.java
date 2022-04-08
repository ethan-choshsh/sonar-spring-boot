package com.choshsh.sonar.sonar.api;

import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    @GetMapping("/hello")
    Mono<String> hello() {
        return Mono.just("Hello World");
    }

    @GetMapping("/user")
    Mono<ResponseEntity<Person>> test() {
        Person person = new Person();
        String foodSecond;
        try {
            foodSecond = "피자";

            person.setName("ethan");
            person.setFavoriteFood("햄버거");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Mono.just(
                ResponseEntity
                        .status(200)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(person));
    }

    @Data
    static class Person {
        String name;
        String favoriteFood;
    }
}
