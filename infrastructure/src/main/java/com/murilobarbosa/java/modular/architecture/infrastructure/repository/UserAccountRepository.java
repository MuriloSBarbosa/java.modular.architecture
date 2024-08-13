package com.murilobarbosa.java.modular.architecture.infrastructure.repository;

import com.murilobarbosa.java.modular.architecture.infrastructure.entity.UserAccountEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, UUID>,
      JpaSpecificationExecutor<UserAccountEntity> {

    boolean existsByEmail(String email);
}
