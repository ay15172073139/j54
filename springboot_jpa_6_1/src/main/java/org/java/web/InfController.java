package org.java.web;


import org.java.entity.Inf;
import org.java.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfController {

    @Autowired
    private InfService service;

    @GetMapping("/init")
    public Iterable<Inf> findAll(){
        return service.findAll();
    }


    @GetMapping("/findById/{id}")
    public Inf findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public Iterable<Inf> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }


    @GetMapping("/ByName/{name}")
    public Iterable<Inf> ByName(@PathVariable("name") String name){
        return service.findByNameCondition(name);
    }

    @GetMapping("/ByPage/{page}")
    public Iterable<Inf> ByPage(@PathVariable("page") Integer page){
        return service.findByPage(page, 3);
    }
}
