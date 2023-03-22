package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "position_job")
@Data
public class PositionJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String position;

    private String job;

    private String detail;

    private String image;

    private String video;

}
