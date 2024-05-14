package com.gfg.jbdll.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MovieRepository extends CrudRepository {

    List find100moviebyOrder();
}
