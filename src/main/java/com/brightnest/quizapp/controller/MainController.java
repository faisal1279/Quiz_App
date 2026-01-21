package com.brightnest.quizapp.controller;

import com.brightnest.quizapp.model.QuestionForm;
import com.brightnest.quizapp.model.Result;
import com.brightnest.quizapp.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final QuizService quizeService;

    @GetMapping("/")
    public String home(){
        return "index";
    }
    @PostMapping("/quiz")
    public String quiz(Model model, RedirectAttributes redirectAttributes, @RequestParam String username){
        if(username.isEmpty()){
            redirectAttributes.addFlashAttribute("warning", "Please enter a username");
            return "redirect:/";
        }

        model.addAttribute("questionForm", quizeService.getQuestionForm());
        model.addAttribute("username", username);
        return "quiz";
    }

    @PostMapping("/submit")
    public String submit(Model model,@ModelAttribute QuestionForm questionForm,@RequestParam String username){
        Result result = new Result();
        result.setUsername(username);
        result.setTotalCorrect(quizeService.getResult(questionForm));
        quizeService.saveResult(result);
        model.addAttribute("result", result);
        return "result";
    }

    @GetMapping("/score")
    public String score(Model model){
        model.addAttribute("scores",quizeService.getResults());
        return "scoreboard";
    }

    @PostMapping("/update-name")
    public String updateName(Model model, @RequestParam String username){
        quizeService.updateName("faisal", username);
        return "redirect:/";
    }

}
