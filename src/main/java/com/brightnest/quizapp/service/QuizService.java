package com.brightnest.quizapp.service;


import com.brightnest.quizapp.model.Question;
import com.brightnest.quizapp.model.QuestionForm;
import com.brightnest.quizapp.model.Result;
import com.brightnest.quizapp.repository.QuestionRepository;
import com.brightnest.quizapp.repository.ResultRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class QuizService {

//    private List<Question> allQuestions;
//    private List<Result> results;
//    private final QuestionInitializer questionInitializer;
//
//    @PostConstruct
//    public void init(){
////       allQuestions = questionInitializer.getQuestions();
//       results = new ArrayList<>();
//    }


    private final QuestionRepository questionRepository;
    private final ResultRepository resultRepository;

    public QuestionForm getQuestionForm(){
        //get random 5 questions for all questions;
        List<Question> allQuestionsCopy = new ArrayList<>(questionRepository.findAll());
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
            if (question.getAns() == question.getChose()){
                totalCorrect++;
            }
        }
        return totalCorrect;
    }
    public void saveResult(Result result){

        resultRepository.save(result);
    }

    public List<Result> getResults() {
        List<Result> allResults = resultRepository.findAll();

        allResults.sort((r1,r2) -> {
            return Integer.compare(r2.getTotalCorrect(),
                    r1.getTotalCorrect());
        });
        return allResults;
    }
    public void updateName(String prevName, String updatedName){
        Result result = resultRepository.findByUsername(prevName);
        result.setUsername(updatedName);
        resultRepository.save(result);
    }
}
