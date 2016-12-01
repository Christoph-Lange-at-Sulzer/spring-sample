package de.sulzer.stgt.sample.springboot.api;


import de.sulzer.stgt.sample.springboot.config.SampleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(SampleProperties.class)
public class SampleController {

    private SampleProperties sampleProperties;

    @Autowired
    public SampleController(SampleProperties sampleProperties) {
        this.sampleProperties = sampleProperties;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello "+ sampleProperties.getName();
    }

}