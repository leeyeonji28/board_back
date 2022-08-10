package com.project.boardback;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/test")
    @ResponseBody
    public String index(){
        return "test";
    }

    @RequestMapping("/")
    public String root(){
        return "redirect:/question/list";
    }
}
