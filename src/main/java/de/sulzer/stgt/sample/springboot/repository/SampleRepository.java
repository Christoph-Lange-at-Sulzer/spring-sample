package de.sulzer.stgt.sample.springboot.repository;

import de.sulzer.stgt.sample.springboot.persitence.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SampleRepository extends CrudRepository<PersonEntity, Long> {


    PersonEntity findByCode(String code);

    PersonEntity findByCodeIgnoreCase(String code);

    List<PersonEntity> findByFirstnameOrLastnameAllIgnoreCase(String firstname, String lastname);

    // int countBy...
    // List<SampleEntity> findByLastnameOrderByFirstnameAsc(String lastname);
}
