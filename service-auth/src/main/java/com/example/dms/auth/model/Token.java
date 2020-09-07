package com.example.dms.auth.model;

import com.example.dms.auth.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.time.DateUtils;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Token {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date expiryTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createTime;
    private Integer expiryIn;
    private UserEntity user;
    private String token;

    @PostConstruct
    protected void postConstruct() {
        token = UUID.randomUUID().toString();
        Date now = new Date();
        createTime = now;
        expiryTime = DateUtils.addHours(now, 1);
        expiryIn = 3600;
    }
}
