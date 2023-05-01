package com.reactivetest.r2db.scores;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document
@Data
public class Scores {
    @Id
    private String id;
    private int score;
}
