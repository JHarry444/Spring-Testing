package com.qa.demo.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.demo.persistence.domain.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
