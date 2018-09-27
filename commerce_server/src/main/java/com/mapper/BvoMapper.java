package com.mapper;

import com.pojo.Bvo;
import com.pojo.BvoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BvoMapper {
    long countByExample(BvoExample example);

    int deleteByExample(BvoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bvo record);

    int insertSelective(Bvo record);

    List<Bvo> selectByExample(BvoExample example);

    Bvo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bvo record, @Param("example") BvoExample example);

    int updateByExample(@Param("record") Bvo record, @Param("example") BvoExample example);

    int updateByPrimaryKeySelective(Bvo record);

    int updateByPrimaryKey(Bvo record);
}