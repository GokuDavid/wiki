package com.goku.wiki.service;

import com.goku.wiki.domain.Ebook;
import com.goku.wiki.domain.EbookExample;
import com.goku.wiki.mapper.EbookMapper;
import com.goku.wiki.req.EbookReq;
import com.goku.wiki.resp.EbookResp;
import com.goku.wiki.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
//        List<EbookResp> respList=new ArrayList<>();
//        for (Ebook ebook : ebookList) {
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(ebook,ebookResp);
//            EbookResp ebookResp= new CopyUtil.copy(ebook, EbookResp.class);
//            respList.add(ebookResp);
//        }
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);
        return list;
    }
    }
