package com.github.dergach.demo.data.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiqnUpController {
    @GetMapping("/siqnup")
    public String siqnup(Model model) {
        return "page/siqnup";
    }
}