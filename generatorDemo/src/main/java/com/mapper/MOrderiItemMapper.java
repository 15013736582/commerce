package com.mapper;

import com.pojo.MOrderiItem;
import com.pojo.MOrderiItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MOrderiItemMapper {
    long countByExample(MOrderiItemExample example);

    int deleteByExample(MOrderiItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MOrderiItem record);

    int insertSelective(MOrderiItem record);

    List<MOrderiItem> selectByExample(MOrderiItemExample example);

    MOrderiItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MOrderiItem record, @Param("example") MOrderiItemExample example);

    int updateByExample(@Param("record") MOrderiItem record, @Param("example") MOrderiItemExample example);

    int updateByPrimaryKeySelective(MOrderiItem record);

    int updateByPrimaryKey(MOrderiItem record);
}