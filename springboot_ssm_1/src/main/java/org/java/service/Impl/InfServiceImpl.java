package org.java.service.Impl;

import org.java.dao.InfMapper;
import org.java.entity.Inf;
import org.java.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InfServiceImpl implements InfService {

    @Autowired
    private InfMapper mapper;

    @Cacheable("springboot_ssm_1")
    @Override
    public Inf findById(Integer id) {
        System.out.println("-------------从数据库加载了数据，主键:"+id);
        return mapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void add(Inf f) {
        mapper.insert(f);
    }

    @Cacheable("getList")
    @Override
    public List<Inf> getList() {
        System.out.println("---------------------从数据库加载了数据................getList");
        return mapper.getList();
    }
}
