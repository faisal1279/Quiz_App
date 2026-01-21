package com.brightnest.quizapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Result {

    @Id
    @GeneratedValue
    private int resultId;
    private String username;
    private int totalCorrect;
}
