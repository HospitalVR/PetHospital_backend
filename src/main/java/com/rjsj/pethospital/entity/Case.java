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

    private long type;

    private String name1;
    private String name2;
    private String name3;

    private String treat1;
    private String treat2;
    private String treat3;

    private String check1;
    private String check2;
    private String check3;

    private String result1;
    private String result2;
    private String result3;

    private String plan1;
    private String plan2;
    private String plan3;
}
