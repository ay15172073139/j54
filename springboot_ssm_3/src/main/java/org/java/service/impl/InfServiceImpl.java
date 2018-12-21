package org.java.service.impl;

import org.java.dao.InfMapper;
import org.java.entity.Inf;
import org.java.service.InfService;
import org.java.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;
@Service
public class InfServiceImpl implements InfService {

    @Autowired
    private JedisCluster cluster;


    @Autowired
    private InfMapper mapper;

    @Override
    public List<Inf> getList() {
        String json=cluster.hget("springboot_ssm_3", "getList");
        List<Inf> list=null;
        if(json==null){
           synchronized (this){
             json=cluster.hget("springboot_ssm_3", "getList");
             if(json==null){
                 System.out.println("从数据库加载数据.................");
                 list=mapper.getList();
                 cluster.hset("springboot_ssm_3", "getList", JsonUtils.objectToJson(list));
             }else{
                 System.out.println("#############################从缓存中加载.....................................");
                 list= JsonUtils.jsonToList(json, Inf.class);
             }
           }
        }else{
            System.out.println("从缓存中加载数据............");
            list= JsonUtils.jsonToList(json, Inf.class);
        }
        return list;
    }

    @Override
    public void add(Inf f) {

    }

    @Override
    public Inf findById(Integer id) {
        return null;
    }
}
