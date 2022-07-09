package com.goku.wiki.controller;

import com.goku.wiki.req.EbookReq;
import com.goku.wiki.resp.CommonResp;
import com.goku.wiki.resp.EbookResp;
import com.goku.wiki.service.EbookService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@MapperScan("com.goku.wiki.mapper")
@RequestMapping("/ebook")
public class EbookController {


    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookReq req) {
        List<EbookResp> list =ebookService.list(req);
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        resp.setContent(list);
        return resp;
    }
}
