package com.mygitgor.notificationservice.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
public abstract class BaseEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;

}