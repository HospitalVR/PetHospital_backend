package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "drug_management")
@Data
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;
    private String description;
}
