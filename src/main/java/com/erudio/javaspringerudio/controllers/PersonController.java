package com.erudio.javaspringerudio.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erudio.javaspringerudio.data.vo.v1.PersonVO;
import com.erudio.javaspringerudio.data.vo.v2.PersonVOV2;
import com.erudio.javaspringerudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
  @Autowired
  private PersonService service;

  @GetMapping
  public ResponseEntity<List<PersonVO>> findAll() {
    List<PersonVO> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<PersonVO> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<PersonVO> create(@RequestBody PersonVO obj) {
    obj = service.create(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(obj);
  }

  @PostMapping(value = "/v2")
  public ResponseEntity<PersonVOV2> createV2(@RequestBody PersonVOV2 obj) {
    obj = service.createV2(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(obj);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<PersonVO> update(@PathVariable Long id, @RequestBody PersonVO obj) {
    obj = service.update(id, obj);
    return ResponseEntity.ok().body(obj);
  }
}
