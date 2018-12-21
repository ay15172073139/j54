package org.java.service;

import java.util.List;
import java.util.Map;

public interface PrdService {

    int getTotal();

    Map findById(Integer id);

    List<Map> getList(Integer currPage,Integer size);
}
