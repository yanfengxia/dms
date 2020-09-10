package com.example.dms.auth.controller;

import com.example.dms.auth.bridge.TokenBridge;
import com.example.dms.auth.entity.UserEntity;
import com.example.dms.auth.model.Token;
import com.example.dms.auth.ro.LoginRO;
import com.example.dms.auth.ro.TokenRO;
import com.example.dms.auth.service.TokenService;
import com.example.dms.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Autowired
    TokenBridge tokenBridge;

    @PostMapping("/login")
    public ResponseEntity<TokenRO> login(@Validated @RequestBody LoginRO loginRO) throws Exception {
        UserEntity userEntity = userService.getUserEntityByUserName(loginRO.getUsername());
        if (userEntity != null) {
            if (userEntity.getPassword().equals(loginRO.getPassword())) {
                Token token = tokenService.createNewToken(userEntity);
                TokenRO tokenRO = tokenBridge.convertTokenToTokenRO(token);
                return new ResponseEntity<>(tokenRO, HttpStatus.OK);
            } else {
                return new ResponseEntity("User login information not correct", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("User login inforation not correct", HttpStatus.BAD_REQUEST);
        }
    }
}
