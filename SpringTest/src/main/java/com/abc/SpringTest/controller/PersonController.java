package com.abc.SpringTest.controller;

import com.abc.SpringTest.dto.PersonDTO;
import com.abc.SpringTest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;
    @PostMapping("/person")
    public PersonDTO insertPerson(@Validated @RequestBody PersonDTO dto) {
        return service.insertPerson(dto);
    }
}
