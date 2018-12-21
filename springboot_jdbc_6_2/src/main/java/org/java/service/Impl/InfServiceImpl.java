package org.java.service.Impl;

import org.java.dao.InfDao;
import org.java.entity.Inf;
import org.java.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InfServiceImpl implements InfService {

    @Autowired
    private InfDao dao;

    @Override
    public void add(Inf f) {
        dao.add(f);
    }

    @Override
    public List<Inf> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Map<String, Object>> findAllMap() {
        return dao.findAllMap();
    }
}
