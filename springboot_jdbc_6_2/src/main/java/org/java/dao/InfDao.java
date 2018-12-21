package org.java.dao;

import org.java.entity.Inf;

import java.util.List;
import java.util.Map;

public interface InfDao {
    void add(Inf f);

    List<Inf> findAll();

    List<Map<String,Object>> findAllMap();
}
