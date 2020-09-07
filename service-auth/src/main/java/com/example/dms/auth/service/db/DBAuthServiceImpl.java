package com.example.dms.auth.service.db;

import com.example.dms.auth.service.IAuthService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DBAuthServiceImpl implements IAuthService {

    final
    JpaRepository jpaRepository;

    public DBAuthServiceImpl(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public boolean verifyUser(String username, String password) {



        return false;
    }
}
