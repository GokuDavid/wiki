package com.goku.wiki.controller;

import com.goku.wiki.req.CategoryQueryReq;
import com.goku.wiki.req.CategorySaveReq;
import com.goku.wiki.resp.CommonResp;
import com.goku.wiki.resp.CategoryQueryResp;
import com.goku.wiki.resp.PageResp;
import com.goku.wiki.service.CategoryService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@MapperScan("com.goku.wiki.mapper")
@RequestMapping("/category")
public class CategoryController {


    @Resource
    private CategoryService categoryService;


    @GetMapping("/list")
    public CommonResp list(@Valid CategoryQueryReq req) {
        PageResp<CategoryQueryResp> list =categoryService.list(req);
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>();
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody CategorySaveReq req) {
        CommonResp resp = new CommonResp<>();
        categoryService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        categoryService.delete(id);
        return resp;
    }
}
