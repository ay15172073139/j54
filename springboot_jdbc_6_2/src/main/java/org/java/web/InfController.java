package org.java.web;

import org.java.entity.Inf;
import org.java.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class InfController {

    @Autowired
    private InfService service;


    @GetMapping("/init")
    public List<Inf> findAll(){
        return service.findAll();
    }


    @GetMapping("/findAllMap")
    public List<Map<String,Object>> findAllMap(){
        return service.findAllMap();
    }

}
