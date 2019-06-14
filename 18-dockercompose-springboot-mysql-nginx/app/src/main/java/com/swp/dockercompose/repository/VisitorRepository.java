package com.swp.dockercompose.repository;

import com.swp.dockercompose.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

    Visitor findByIp(String ip);

}
