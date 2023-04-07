package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "staff_management")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int age;
    private String gender;
    private String position;
    private int experience;
    private String phone;
    private String idnumber;
    private Date date;
    private String place;
    private String edu;

}
