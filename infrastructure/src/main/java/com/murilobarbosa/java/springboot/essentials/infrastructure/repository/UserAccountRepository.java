package com.murilobarbosa.java.springboot.essentials.infrastructure.repository;

import com.murilobarbosa.java.springboot.essentials.infrastructure.entity.UserAccountEntity;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, UUID>,
      JpaSpecificationExecutor<UserAccountEntity> {

    boolean existsByEmail(String email);
}
