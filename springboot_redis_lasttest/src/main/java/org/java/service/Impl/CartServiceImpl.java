package org.java.service.Impl;

import org.java.dao.CartMapper;
import org.java.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public Map getCartById(Integer id) {
        return cartMapper.getCartById(id);
    }

    @Override
    @Cacheable(value = "getCart")
    public List<Map> getCart() {
        return cartMapper.getCart();
    }

    @Override
    @Transactional
    @CacheEvict(value ="getCart",allEntries = true)
    public void add(Map m) {
        cartMapper.addCart(m);
    }

    @Override
    @Transactional
    @CacheEvict(value ="getCart",allEntries = true)
    public void update(Map m) {
       cartMapper.update(m);
    }

    @Override
    @Transactional
    @CacheEvict(value ="getCart",allEntries = true)
    public void delById(Integer id) {
        cartMapper.delById(id);
    }

    @Override
    @Transactional
    @CacheEvict(value ="getCart",allEntries = true)
    public void delallCart() {
        cartMapper.delallCart();
    }
}
