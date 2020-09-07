package com.example.dms.auth.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class UserEntity extends BaseEntity {
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;
}