package com.example.dms.auth.service;

import com.example.dms.auth.entity.UserEntity;
import com.example.dms.auth.model.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TokenService {

    @Cacheable(value = "token", key = "#userEntity.id")
    public Token createNewToken(UserEntity userEntity) {
        try {
            Token token = Token.builder()
                    .user(userEntity)
                    .build();
            return token;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

}
