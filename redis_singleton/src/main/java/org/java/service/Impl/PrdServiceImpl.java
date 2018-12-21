package org.java.service.Impl;

import org.java.dao.PrdMapper;
import org.java.entity.Prd;
import org.java.jedis.JedisClient;
import org.java.service.PrdService;
import org.java.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrdServiceImpl implements PrdService {

    @Autowired
    private PrdMapper mapper;

    @Autowired
    @Qualifier("cluster")
    private JedisClient client;

    @Override
    public List<Prd> getList() {
        String value=client.hget("redis_singleton", "getList");
        if(value!=null){
            System.out.println("from redis");
            List<Prd> list= JsonUtils.jsonToList(value, Prd.class);
            return list;
        }
        System.out.println("from database");
        List<Prd> list=mapper.getList();
        String json=JsonUtils.objectToJson(list);
        client.hset("redis_singleton", "getList",json);
        return list;
    }

    @Override
    public Prd findByid(String pid) {
        String value =client.hget("redis_singleton", pid);
        if (value!=null){
            System.out.println("from redis"+pid);
            Prd p=JsonUtils.jsonToPojo(value, Prd.class);
            return p;
        }
        System.out.println("from database"+pid);
        Prd p=mapper.findById(pid);
        String json=JsonUtils.objectToJson(p);
        client.hset("redis_singleton", pid,json);
        return p;
    }
}
