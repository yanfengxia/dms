package com.example.dms.auth.dao;

import com.example.dms.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityDao  extends JpaRepository<UserEntity, Long> {
}
