package com.brightnest.quizapp.service;


import com.brightnest.quizapp.model.Question;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class QuestionInitializer {
    private List<Question> questions;

    @PostConstruct  //constructor run howar por por eti run hobe
    public void init() {
        questions = new ArrayList<>();

        questions.add(new Question(1,
                "What is a correct syntax to output \"Hello World\" in Java",
                "echo \"Hello world\"",
                "printf(\"Hello World\")",
                "System.out.println(\"Hello World\")",
                3, -1));questions.add(new Question(1,
                "What is a correct syntax to output \"Hello World\" in Java?",
                "echo \"Hello World\"",
                "printf(\"Hello World\")",
                "System.out.println(\"Hello World\")",
                3, -1));

        questions.add(new Question(2,
                "Which keyword is used to create an object in Java?",
                "class",
                "new",
                "object",
                2, -1));

        questions.add(new Question(3,
                "Which method is the entry point of a Java program?",
                "start()",
                "run()",
                "main()",
                3, -1));

        questions.add(new Question(4,
                "Which of the following is NOT a Java data type?",
                "int",
                "float",
                "real",
                3, -1));

        questions.add(new Question(5,
                "Which keyword is used to inherit a class in Java?",
                "implements",
                "inherits",
                "extends",
                3, -1));

        questions.add(new Question(6,
                "Which access modifier makes a variable visible everywhere?",
                "private",
                "protected",
                "public",
                3, -1));

        questions.add(new Question(7,
                "Which of these is used to handle exceptions in Java?",
                "try-catch",
                "if-else",
                "throwable",
                1, -1));

        questions.add(new Question(8,
                "Which collection does NOT allow duplicate values?",
                "List",
                "Set",
                "ArrayList",
                2, -1));

        questions.add(new Question(9,
                "Which keyword is used to stop inheritance?",
                "static",
                "final",
                "private",
                2, -1));

        questions.add(new Question(10,
                "Which loop is guaranteed to run at least once?",
                "for loop",
                "while loop",
                "do-while loop",
                3, -1));

        questions.add(new Question(11,
                "Which Java feature allows method overloading?",
                "Inheritance",
                "Polymorphism",
                "Encapsulation",
                2, -1));

        questions.add(new Question(12,
                "Which keyword is used to create a subclass?",
                "this",
                "super",
                "extends",
                3, -1));

        questions.add(new Question(13,
                "Which package is automatically imported in Java?",
                "java.util",
                "java.io",
                "java.lang",
                3, -1));

        questions.add(new Question(14,
                "Which keyword is used to define an interface?",
                "interface",
                "implements",
                "abstract",
                1, -1));

        questions.add(new Question(15,
                "Which of the following is a marker interface?",
                "Runnable",
                "Serializable",
                "Comparable",
                2, -1));

        questions.add(new Question(16,
                "Which concept hides internal details from the user?",
                "Inheritance",
                "Abstraction",
                "Polymorphism",
                2, -1));

        questions.add(new Question(17,
                "Which collection follows FIFO order?",
                "Stack",
                "Queue",
                "Set",
                2, -1));

        questions.add(new Question(18,
                "Which keyword is used to call parent class constructor?",
                "this",
                "parent",
                "super",
                3, -1));

        questions.add(new Question(19,
                "Which Java version introduced Lambda expressions?",
                "Java 5",
                "Java 7",
                "Java 8",
                3, -1));

        questions.add(new Question(20,
                "Which Spring annotation is used to define a service class?",
                "@Component",
                "@Service",
                "@Repository",
                2, -1));

    }
}
