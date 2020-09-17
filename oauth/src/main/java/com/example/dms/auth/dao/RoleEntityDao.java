package com.example.dms.auth.dao;

import com.example.dms.auth.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityDao extends JpaRepository<RoleEntity, Long> {
}
