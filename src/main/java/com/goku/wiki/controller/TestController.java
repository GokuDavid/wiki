package com.goku.wiki.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @RequestMapping("/hello")
    public String Hello() {
        return "Hello World!";
    }
}
