package org.java.service.Impl;

import org.java.dao.InfDao;
import org.java.entity.Inf;
import org.java.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfServiceImpl implements InfService {

    @Autowired
    private InfDao dao;

    @Override
    public Iterable<Inf> findAll() {
        int a=2/0;
        return dao.findAll();
    }

    @Override
    public Inf findById(Integer id) {
        Optional op=dao.findById(id);
        return (Inf) op.get();
    }

    @Override
    public Iterable<Inf> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Iterable<Inf> findByNameCondition(String name) {
        return dao.Byname(name);
    }

    @Override
    public List<Inf> findByPage(Integer page, Integer size) {
        Sort sort=Sort.by(Sort.Order.desc("age"));
        PageRequest pg=PageRequest.of(page-1,size,sort);
        Page<Inf> p=dao.findAll(pg);
        return p.getContent();
    }
}
