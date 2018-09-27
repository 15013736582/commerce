package com.mapper;

import com.pojo.Gvo;
import com.pojo.GvoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GvoMapper {
    long countByExample(GvoExample example);

    int deleteByExample(GvoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gvo record);

    int insertSelective(Gvo record);

    List<Gvo> selectByExample(GvoExample example);

    int updateByExampleSelective(@Param("record") Gvo record, @Param("example") GvoExample example);

    int updateByExample(@Param("record") Gvo record, @Param("example") GvoExample example);
}