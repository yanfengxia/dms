package com.example.dms.auth.service;

import com.example.dms.auth.entity.UserEntity;
import com.example.dms.auth.model.Token;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class TokenService {

    @CachePut(value = "token", key = "#result.token")
    public Token createNewToken(UserEntity userEntity) {
        Date now = new Date();
        try {
            Token token = Token.builder()
                    .createTime(now)
                    .expiryTime(DateUtils.addHours(now, 1))
                    .expiryIn(3600)
                    .token(UUID.randomUUID().toString())
                    .user(userEntity)
                    .build();
            return token;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

}
