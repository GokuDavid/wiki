package com.goku.wiki.mapper;

import com.goku.wiki.domain.Demo;
import com.goku.wiki.domain.DemoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoMapper {
    long countByExample(DemoExample example);

    int deleteByExample(DemoExample example);

    int insert(Demo row);

    int insertSelective(Demo row);

    List<Demo> selectByExample(DemoExample example);

    int updateByExampleSelective(@Param("row") Demo row, @Param("example") DemoExample example);

    int updateByExample(@Param("row") Demo row, @Param("example") DemoExample example);
}