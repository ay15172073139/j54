package org.java.service;

import org.java.entity.Inf;

import java.util.List;

public interface InfService {
    Iterable<Inf> findAll();

    Inf findById(Integer id);

    Iterable<Inf> findByName(String name);

    Iterable<Inf> findByNameCondition(String name);


    List<Inf> findByPage(Integer page, Integer size);
}
