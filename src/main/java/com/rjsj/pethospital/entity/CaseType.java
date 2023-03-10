package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "case_type")
@Data
public class CaseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
}
