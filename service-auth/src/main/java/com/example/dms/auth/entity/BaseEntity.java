package com.example.dms.auth.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Temporal(TemporalType.TIMESTAMP)
   private Date createdAt;

   @Temporal(TemporalType.TIMESTAMP)
   private Date updatedAt;

   @PrePersist
   protected void onCreate() {
      createdAt = updatedAt = new Date();
   }

   @PreUpdate
   protected void onUpdate() {
      updatedAt = new Date();
   }

}
