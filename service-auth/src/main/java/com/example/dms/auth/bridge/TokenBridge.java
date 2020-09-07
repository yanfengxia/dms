package com.example.dms.auth.bridge;

import com.example.dms.auth.model.Token;
import com.example.dms.auth.ro.TokenRO;
import org.springframework.stereotype.Component;

@Component
public class TokenBridge {
    public TokenRO convertTokenToTokenRO(Token token) {
        return TokenRO.builder()
                .token(token.getToken())
                .expiretime(token.getExpiryTime())
                .expiryin(token.getExpiryIn())
                .build();
    }
}
