package com.vishnu.EmpController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeCotroller {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
