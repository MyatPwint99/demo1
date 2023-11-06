package com.ojt.demo1.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Car {
    @Id
    Long id;
    String brand;
    String color;
    Boolean isNew;
    Integer modelNo;
    Date createdAt;
}
