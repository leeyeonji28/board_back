package com.project.boardback.question.controller;

import com.project.boardback.question.domain.Question;
import com.project.boardback.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {
//    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    @RequestMapping("/question/list")
//    @ResponseBody
    public String list(Model model){
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
