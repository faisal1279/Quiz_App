package com.brightnest.quizapp.service;


import com.brightnest.quizapp.model.Question;
import com.brightnest.quizapp.model.QuestionForm;
import com.brightnest.quizapp.model.Result;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class QuizeService {

    private List<Question> allQuestions;
    private List<Result> results;
    private final QuestionInitializer questionInitializer;

    @PostConstruct
    public void init(){
       allQuestions = questionInitializer.getQuestions();
       results = new ArrayList<>();
    }

    public QuestionForm getQuestionForm(){
        //get random 5 questions for all questions;
        List<Question> allQuestionsCopy = new ArrayList<>(allQuestions);
        List<Question> selectedQuestion = new ArrayList<>();

        Random rand = new Random();
        for( int i = 0; i < 5; i++ ){
            int randomNumber=rand.nextInt(allQuestionsCopy.size());
            selectedQuestion.add(allQuestionsCopy.get(randomNumber));
            allQuestionsCopy.remove(randomNumber);
        }

        return new QuestionForm(selectedQuestion);
    }

    public int getResult(QuestionForm questionForm){
        int totalCorrect = 0;
        for(Question question : questionForm.getQuestions()){
            if (question.getAns() == question.getChoose()){
                totalCorrect++;
            }
        }
        return totalCorrect;
    }
    public void saveResult(Result result){
        results.add(result);
    }

    public List<Result> getResults() {
        results.sort((r1,r2) -> {
            return Integer.compare(r2.getTotalCorrect(),
                    r1.getTotalCorrect());
        });
        return results;
    }
}
