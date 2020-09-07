package com.example.dms.auth.entity;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Builder
@Entity
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
}
