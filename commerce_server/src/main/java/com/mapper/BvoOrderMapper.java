package com.mapper;

import com.pojo.BvoOrder;
import com.pojo.BvoOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BvoOrderMapper {
    long countByExample(BvoOrderExample example);

    int deleteByExample(BvoOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BvoOrder record);

    int insertSelective(BvoOrder record);

    List<BvoOrder> selectByExample(BvoOrderExample example);

    BvoOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BvoOrder record, @Param("example") BvoOrderExample example);

    int updateByExample(@Param("record") BvoOrder record, @Param("example") BvoOrderExample example);

    int updateByPrimaryKeySelective(BvoOrder record);

    int updateByPrimaryKey(BvoOrder record);
}