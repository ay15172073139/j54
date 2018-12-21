package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {

    Map getCartById(@Param("id") Integer id);
    List<Map> getCart();
    void addCart(Map m);
    void update(Map m);
    void delallCart();
    void delById(@Param("id") Integer id);
}
