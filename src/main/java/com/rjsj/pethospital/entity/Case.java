package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "case_management")
@Data
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    private String name1;
}
