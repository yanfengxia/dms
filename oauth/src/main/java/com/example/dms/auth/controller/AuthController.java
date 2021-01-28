package com.example.dms.auth.controller;

import com.example.dms.auth.bridge.TokenBridge;
import com.example.dms.auth.entity.UserEntity;
import com.example.dms.auth.exception.InvalidPasswordException;
import com.example.dms.auth.exception.InvalidUserNameException;
import com.example.dms.auth.model.Token;
import com.example.dms.auth.ro.LoginRO;
import com.example.dms.auth.ro.TokenRO;
import com.example.dms.auth.service.TokenService;
import com.example.dms.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @PostMapping("/token")
    public ResponseEntity<TokenRO> generateToken(@Validated @RequestBody LoginRO loginRO) throws Exception {
        UserEntity userEntity = userService.getUserEntityByUserName(loginRO.getUsername());
        if (userEntity != null) {
            if (userEntity.getPassword().equals(loginRO.getPassword())) {
                Token token = tokenService.createNewToken(userEntity);
                TokenRO tokenRO = tokenBridge.convertTokenToTokenRO(token);
                return new ResponseEntity<>(tokenRO, HttpStatus.OK);
            } else {
                throw new InvalidPasswordException();
            }
        } else {
            throw new InvalidUserNameException();
        }
    }
}
