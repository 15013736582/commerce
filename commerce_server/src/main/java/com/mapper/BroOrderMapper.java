package com.mapper;

import com.pojo.BroOrder;
import com.pojo.BroOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BroOrderMapper {
    long countByExample(BroOrderExample example);

    int deleteByExample(BroOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BroOrder record);

    int insertSelective(BroOrder record);

    List<BroOrder> selectByExample(BroOrderExample example);

    BroOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BroOrder record, @Param("example") BroOrderExample example);

    int updateByExample(@Param("record") BroOrder record, @Param("example") BroOrderExample example);

    int updateByPrimaryKeySelective(BroOrder record);

    int updateByPrimaryKey(BroOrder record);
}