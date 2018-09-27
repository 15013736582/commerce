package com.mapper;

import com.pojo.BOrderItem;
import com.pojo.BOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BOrderItemMapper {
    long countByExample(BOrderItemExample example);

    int deleteByExample(BOrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BOrderItem record);

    int insertSelective(BOrderItem record);

    List<BOrderItem> selectByExample(BOrderItemExample example);

    BOrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BOrderItem record, @Param("example") BOrderItemExample example);

    int updateByExample(@Param("record") BOrderItem record, @Param("example") BOrderItemExample example);

    int updateByPrimaryKeySelective(BOrderItem record);

    int updateByPrimaryKey(BOrderItem record);
}