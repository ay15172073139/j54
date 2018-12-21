package org.java.service;

import org.java.entity.Inf;

import java.util.List;
import java.util.Map;

public interface InfService {
    void add(Inf f);

    List<Inf> findAll();


    List<Map<String,Object>> findAllMap();
}
