package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PrdMapper {
    int getTotal();

    Map findById(@Param("id") Integer id);

    List<Map> getList(@Param("startIndex") Integer startIndex, @Param("size") Integer size);

}
