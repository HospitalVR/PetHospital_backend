package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "department_management")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private String head;
}
