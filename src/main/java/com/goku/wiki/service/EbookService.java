package com.goku.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.wiki.domain.Ebook;
import com.goku.wiki.domain.EbookExample;
import com.goku.wiki.mapper.EbookMapper;
import com.goku.wiki.req.EbookQueryReq;
import com.goku.wiki.req.EbookSaveReq;
import com.goku.wiki.resp.EbookQueryResp;
import com.goku.wiki.resp.PageResp;
import com.goku.wiki.util.CopyUtil;
import com.goku.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);
    @Resource
    private EbookMapper ebookMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<EbookQueryResp> list(EbookQueryReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");
        }
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo=new PageInfo<>(ebookList);
        LOG.info("总行数:{}",pageInfo.getTotal());
        LOG.info("总页数:{}",pageInfo.getPages());
//        List<EbookResp> respList=new ArrayList<>();
//        for (Ebook ebook : ebookList) {
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(ebook,ebookResp);
//            EbookResp ebookResp= new CopyUtil.copy(ebook, EbookResp.class);
//            respList.add(ebookResp);
//        }
        List<EbookQueryResp> list = CopyUtil.copyList(ebookList, EbookQueryResp.class);
        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void save(EbookSaveReq req){
        Ebook ebook =CopyUtil.copy(req,Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())){
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        }else {
        ebookMapper.updateByPrimaryKey(ebook);}
    }

}
