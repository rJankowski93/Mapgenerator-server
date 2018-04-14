package com.mgr.mapGenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class BasicController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "HELLO");
        return "welcome";
    }
}
