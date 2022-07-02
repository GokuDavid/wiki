package com.goku.wiki.controller;

import com.goku.wiki.domain.Demo;
import com.goku.wiki.service.DemoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@MapperScan("com.goku.wiki.mapper")
@RequestMapping("/demo")
public class DemoController {


    @Resource
    private DemoService demoService;

    @GetMapping("/list")
    public List<Demo> list() {
        return demoService.list();
    }
}
