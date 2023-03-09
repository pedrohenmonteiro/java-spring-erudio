package com.erudio.javaspringerudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erudio.javaspringerudio.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
