package com.choshsh.sonar.sonar.api;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
public class HelloController {

    private HelloController(){}

    @GetMapping("/hello")
    Flux<String> hello() {
        return Flux.just("Hello", "World");
    }

    @GetMapping("/user")
    ResponseEntity<Person> test() {
        String foodSecond;
        try {
            foodSecond = "피자";
        }catch (Exception e){
            log.warn("음식 이름 설정 오류 : {}", e.getMessage());
        }

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
