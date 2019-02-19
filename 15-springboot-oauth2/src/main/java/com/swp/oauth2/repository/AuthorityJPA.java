package com.swp.oauth2.repository;

import com.swp.oauth2.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityJPA extends JpaRepository<Authority, String> {

}
