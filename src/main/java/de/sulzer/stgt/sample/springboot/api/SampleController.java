package de.sulzer.stgt.sample.springboot.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }

}