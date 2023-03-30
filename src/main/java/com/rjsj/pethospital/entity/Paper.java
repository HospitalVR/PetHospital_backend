package com.rjsj.pethospital.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paper")
@Data

public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "paper_question",
            joinColumns = @JoinColumn(name = "paper_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions=new ArrayList<>();

    private long period;

    private long total_score;
}
