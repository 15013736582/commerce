package com.mapper;

import com.pojo.Mvo;
import com.pojo.MvoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MvoMapper {
    long countByExample(MvoExample example);

    int deleteByExample(MvoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mvo record);

    int insertSelective(Mvo record);

    List<Mvo> selectByExample(MvoExample example);

    Mvo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mvo record, @Param("example") MvoExample example);

    int updateByExample(@Param("record") Mvo record, @Param("example") MvoExample example);

    int updateByPrimaryKeySelective(Mvo record);

    int updateByPrimaryKey(Mvo record);
}