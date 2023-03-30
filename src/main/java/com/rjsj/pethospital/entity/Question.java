package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    private String A_choice;

    private String B_choice;

    private String C_choice;

    private String D_choice;

    private String answer;

    private String type;

    private long score;


}
