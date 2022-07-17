package com.goku.wiki.controller;

import com.goku.wiki.req.EbookQueryReq;
import com.goku.wiki.req.EbookSaveReq;
import com.goku.wiki.resp.CommonResp;
import com.goku.wiki.resp.EbookQueryResp;
import com.goku.wiki.resp.PageResp;
import com.goku.wiki.service.EbookService;
import com.goku.wiki.util.SnowFlake;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@MapperScan("com.goku.wiki.mapper")
@RequestMapping("/ebook")
public class EbookController {


    @Resource
    private EbookService ebookService;


    @GetMapping("/list")
    public CommonResp list(@Valid EbookQueryReq req) {
        PageResp<EbookQueryResp> list =ebookService.list(req);
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        ebookService.delete(id);
        return resp;
    }
}
