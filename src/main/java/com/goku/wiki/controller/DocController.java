package com.goku.wiki.controller;

import com.goku.wiki.req.DocQueryReq;
import com.goku.wiki.req.DocSaveReq;
import com.goku.wiki.resp.DocQueryResp;
import com.goku.wiki.resp.CommonResp;
import com.goku.wiki.resp.PageResp;
import com.goku.wiki.service.DocService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RestController
@MapperScan("com.goku.wiki.mapper")
@RequestMapping("/doc")
public class DocController {


    @Resource
    private DocService docService;

    @GetMapping("/all")
    public CommonResp all() {
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>();
        List<DocQueryResp> list =docService.all();
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/list")
    public CommonResp list(@Valid DocQueryReq req) {
        PageResp<DocQueryResp> list =docService.list(req);
        CommonResp<PageResp<DocQueryResp>> resp = new CommonResp<>();
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req) {
        CommonResp resp = new CommonResp<>();
        docService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        docService.delete(id);
        return resp;
    }
}
