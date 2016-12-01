package de.sulzer.stgt.sample.springboot.api;


import de.sulzer.stgt.sample.springboot.config.SampleProperties;
import de.sulzer.stgt.sample.springboot.exception.PersonNotFoundException;
import de.sulzer.stgt.sample.springboot.persistence.PersonEntity;
import de.sulzer.stgt.sample.springboot.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableConfigurationProperties(SampleProperties.class)
public class SampleController {

    private SampleProperties sampleProperties;
    private SampleRepository sampleRepository;

    @Autowired
    public SampleController(SampleProperties sampleProperties, SampleRepository sampleRepository) {
        this.sampleProperties = sampleProperties;
        this.sampleRepository = sampleRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello " + sampleProperties.getName();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/person/{code}", method = RequestMethod.POST)
    @ResponseBody
    public PersonEntity createPerson(@PathVariable String code, @RequestParam String firstname, @RequestParam String lastname) {
        PersonEntity entity = new PersonEntity();
        entity.setCode(code);
        entity.setFirstname(firstname);
        entity.setLastname(lastname);

        return sampleRepository.save(entity);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/person/{code}/hello", method = RequestMethod.GET)
    public String helloUser(@PathVariable String code) throws PersonNotFoundException {
        PersonEntity entity = sampleRepository.findByCode(code);

        if (entity == null) {
            throw new PersonNotFoundException("Person with code " + code + " not found.");
        }
        return "Hello " + entity.getFirstname() + " " + entity.getLastname();
    }
}