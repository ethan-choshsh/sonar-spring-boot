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
        String foodSecond;
        try {
            foodSecond = "피자";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Person person = new Person();
        person.setName("ethan");
        person.setFavoriteFood("햄버거");

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
