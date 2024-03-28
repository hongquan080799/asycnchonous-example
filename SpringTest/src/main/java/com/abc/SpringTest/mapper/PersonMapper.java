package com.abc.SpringTest.mapper;

import com.abc.SpringTest.dto.PersonDTO;
import com.abc.SpringTest.entity.PersonEntity;
import org.springframework.beans.BeanUtils;

public class PersonMapper {
    public static PersonEntity map (PersonDTO personDTO) {
        PersonEntity entity = new PersonEntity();
        BeanUtils.copyProperties(personDTO, entity);
        return entity;
    }

    public static PersonDTO map (PersonEntity personEntity) {
        PersonDTO dto = new PersonDTO();
        BeanUtils.copyProperties(personEntity, dto);
        return dto;
    }
}
