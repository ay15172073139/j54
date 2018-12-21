package org.java.service.Impl;

import org.java.dao.PrdMapper;
import org.java.service.PrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PrdServiceImpl implements PrdService {

    @Autowired
    private PrdMapper prdMapper;

    @Override
    @Cacheable(value = "getList")
    public List<Map> getList(Integer currPage,Integer size) {
        int startIndex=(currPage-1)*size;
        return prdMapper.getList(startIndex, size);
    }

    @Override
    @Cacheable(value = "getTotal")
    public int getTotal() {
        return prdMapper.getTotal();
    }

    @Override
    @Cacheable(value = "findById")
    public Map findById(Integer id) {
        return prdMapper.findById(id);
    }
}
