package com.brightnest.quizapp.repository;

import com.brightnest.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
