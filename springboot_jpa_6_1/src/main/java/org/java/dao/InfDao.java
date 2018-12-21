package org.java.dao;

import org.java.entity.Inf;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface InfDao extends PagingAndSortingRepository<Inf,Integer> {

    Iterable<Inf> findByName(String name);


    @Query("from Inf where name like %:name%")
    public Iterable<Inf> Byname(@Param("name") String name);

}
