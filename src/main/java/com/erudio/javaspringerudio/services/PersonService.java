package com.erudio.javaspringerudio.services;

import com.erudio.javaspringerudio.exceptions.ResourceNotFoundException;
import com.erudio.javaspringerudio.model.Person;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.javaspringerudio.repositories.PersonRepository;

@Service
public class PersonService {

  @Autowired
  private PersonRepository repository;

  public List<Person> findAll() {
    return repository.findAll();
  }

  public Person findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
  }
}
