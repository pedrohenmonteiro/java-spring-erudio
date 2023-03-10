package com.erudio.javaspringerudio.mapper.custom;

import org.springframework.stereotype.Service;

import com.erudio.javaspringerudio.data.vo.v2.PersonVOV2;
import com.erudio.javaspringerudio.model.Person;
import java.util.Date;

@Service
public class PersonMapper {

  public PersonVOV2 convertEntityToVo(Person person) {
    PersonVOV2 vo = new PersonVOV2();
    vo.setId(person.getId());
    vo.setFirstName(person.getFirstName());
    vo.setLastName(person.getLastName());
    vo.setGender(person.getGender());
    vo.setAddress(person.getAddress());
    vo.setBirthday(new Date());
    return vo;
  }

  public Person convertVoToEntity(PersonVOV2 person) {
    Person entity = new Person();
    entity.setId(person.getId());
    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setGender(person.getGender());
    entity.setAddress(person.getAddress());
    return entity;
  }
}
