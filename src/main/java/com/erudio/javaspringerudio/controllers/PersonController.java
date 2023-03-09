package com.erudio.javaspringerudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erudio.javaspringerudio.model.Person;
import com.erudio.javaspringerudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
  @Autowired
  private PersonService service;

  @GetMapping
  public ResponseEntity<List<Person>> findAll() {
    List<Person> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Person> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(service.findById(id));
  }
}
