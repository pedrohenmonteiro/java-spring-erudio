package com.erudio.javaspringerudio.services;

import com.erudio.javaspringerudio.data.vo.v1.PersonVO;
import com.erudio.javaspringerudio.data.vo.v2.PersonVOV2;
import com.erudio.javaspringerudio.exceptions.ResourceNotFoundException;
import com.erudio.javaspringerudio.mapper.DozerMapper;
import com.erudio.javaspringerudio.mapper.custom.PersonMapper;
import com.erudio.javaspringerudio.model.Person;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.javaspringerudio.repositories.PersonRepository;

@Service
public class PersonService {

  @Autowired
  private PersonRepository repository;

  @Autowired
  private PersonMapper mapper;

  private static final String ERROR_MSG = "This resource was not found";

  public List<PersonVO> findAll() {
    return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
  }

  public PersonVO findById(Long id) {
    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ERROR_MSG));
    return DozerMapper.parseObject(entity, PersonVO.class);
  }

  public PersonVO create(PersonVO obj) {
    var entity = DozerMapper.parseObject(obj, Person.class);
    return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
  }

  public PersonVOV2 createV2(PersonVOV2 obj) {
    var entity = mapper.convertVoToEntity(obj);
    return mapper.convertEntityToVo(repository.save(entity));
  }

  public void delete(Long id) {
    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ERROR_MSG));
    repository.delete(entity);
  }

  public PersonVO update(Long id, PersonVO obj) {
    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ERROR_MSG));
    updateData(entity, obj);
    return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
  }

  private void updateData(Person entity, PersonVO obj) {
    entity.setFirstName(obj.getFirstName());
    entity.setLastName(obj.getLastName());
    entity.setGender(obj.getGender());
    entity.setAddress(obj.getAddress());
  }
}
