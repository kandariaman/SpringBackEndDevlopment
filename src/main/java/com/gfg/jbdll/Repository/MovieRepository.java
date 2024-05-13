package com.gfg.jbdll.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository {

    void find100moviebyOrder();
}
