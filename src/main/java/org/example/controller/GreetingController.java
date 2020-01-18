package org.example.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @RequestMapping(method = RequestMethod.GET,path = "helloworld")
    public ResponseEntity<String> getHello(){
        ResponseEntity<String> responseEntity = new ResponseEntity<>("helloworld",HttpStatus.OK);
        return responseEntity;
    }


}
