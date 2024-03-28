package com.abc.SpringTest.service;

import com.abc.SpringTest.dto.PersonDTO;
import com.abc.SpringTest.entity.PersonEntity;
import com.abc.SpringTest.mapper.PersonMapper;
import com.abc.SpringTest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;
    public PersonDTO insertPerson(PersonDTO dto) {
        PersonEntity entity = PersonMapper.map(dto);
        return PersonMapper.map(repository.save(entity));
    }

}
