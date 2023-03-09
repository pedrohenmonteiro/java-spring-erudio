package com.erudio.javaspringerudio.services;

import com.erudio.javaspringerudio.data.vo.v1.PersonVO;
import com.erudio.javaspringerudio.exceptions.ResourceNotFoundException;
import com.erudio.javaspringerudio.model.Person;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.javaspringerudio.repositories.PersonRepository;

@Service
public class PersonService {

  @Autowired
  private PersonRepository repository;
  private static final String ERROR_MSG = "This resource was not found";

  public List<PersonVO> findAll() {
    return repository.findAll();
  }

  public PersonVO findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ERROR_MSG));
  }

  public PersonVO create(PersonVO obj) {
    return repository.save(obj);
  }

  public void delete(Long id) {
    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ERROR_MSG));
    repository.delete(entity);
  }

  public PersonVO update(Long id, PersonVO obj) {
    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ERROR_MSG));
    updateData(entity, obj);
    return repository.save(entity);
  }

  private void updateData(Person entity, Person obj) {
    entity.setFirstName(obj.getFirstName());
    entity.setLastName(obj.getLastName());
    entity.setGender(obj.getGender());
    entity.setAddress(obj.getAddress());
  }
}
