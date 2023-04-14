package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "record_management")
@Data
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String breed;
    private int age;
    private String gender;
    private String color;
    private String owner;
    private String phone;
    private String disease;
    private String doctor;
    private String charge;
    private String drug;
    private String vaccine;
    private String assay;
    private String inpatient;
    private String department;

}
