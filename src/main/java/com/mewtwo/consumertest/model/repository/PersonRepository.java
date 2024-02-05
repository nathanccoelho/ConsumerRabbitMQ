package com.mewtwo.consumertest.model.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.mewtwo.consumertest.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
