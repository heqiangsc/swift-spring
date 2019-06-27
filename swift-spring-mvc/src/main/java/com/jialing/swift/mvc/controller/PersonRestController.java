package com.jialing.swift.mvc.controller;


import com.jialing.swift.mvc.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RequestMapping("/p")
@RestController
public class PersonRestController {


    @GetMapping("/person/{id}")
    public Person person(@PathVariable int id, @RequestParam(required = false) String name) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }


    @RequestMapping(value = "/properties/to/json",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, //accpet
        consumes = "application/properties+person") //content-type
    public Person propertiesToJson(@RequestBody Person p) {
        return p;
    }


    @RequestMapping(value = "/json/to/properties",
            produces = "application/properties+person",//accpet
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE //content-type
            )
    public Person  jsonToProperties(@RequestBody Person p) {
        return p;
    }

}
