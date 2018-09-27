package com.mapper;

import com.pojo.MvoOrder;
import com.pojo.MvoOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MvoOrderMapper {
    long countByExample(MvoOrderExample example);

    int deleteByExample(MvoOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MvoOrder record);

    int insertSelective(MvoOrder record);

    List<MvoOrder> selectByExample(MvoOrderExample example);

    MvoOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MvoOrder record, @Param("example") MvoOrderExample example);

    int updateByExample(@Param("record") MvoOrder record, @Param("example") MvoOrderExample example);

    int updateByPrimaryKeySelective(MvoOrder record);

    int updateByPrimaryKey(MvoOrder record);
}