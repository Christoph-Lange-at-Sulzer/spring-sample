package de.sulzer.stgt.sample.springboot.repository;

import de.sulzer.stgt.sample.springboot.persistence.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<PersonEntity, Long> {

    PersonEntity findByCode(String code);

}