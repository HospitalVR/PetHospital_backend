package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inpatient_management")
@Data
public class Inpatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String breed;
    private String owner;
    private String phone;
    private String reason;
    private Date admission;
    private Date discharge;
    private long day;
    private double cost;

}
