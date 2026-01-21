package com.brightnest.quizapp.repository;

import com.brightnest.quizapp.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result,Integer> {
    Result findByUsername(String username);
}
