package com.mapper;

import com.pojo.Dic;
import com.pojo.DicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicMapper {
    long countByExample(DicExample example);

    int deleteByExample(DicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dic record);

    int insertSelective(Dic record);

    List<Dic> selectByExample(DicExample example);

    Dic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dic record, @Param("example") DicExample example);

    int updateByExample(@Param("record") Dic record, @Param("example") DicExample example);

    int updateByPrimaryKeySelective(Dic record);

    int updateByPrimaryKey(Dic record);
}