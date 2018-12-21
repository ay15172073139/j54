package org.java.service;

import java.util.List;
import java.util.Map;

public interface CartService {
    Map getCartById(Integer id);
    List<Map> getCart();
    void add(Map m);
    void update(Map m);
    void delallCart();
    void delById(Integer id);

}
