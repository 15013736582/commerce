package com.mapper;

import com.pojo.Wish;
import com.pojo.WishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WishMapper {
    long countByExample(WishExample example);

    int deleteByExample(WishExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Wish record);

    int insertSelective(Wish record);

    List<Wish> selectByExample(WishExample example);

    Wish selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Wish record, @Param("example") WishExample example);

    int updateByExample(@Param("record") Wish record, @Param("example") WishExample example);

    int updateByPrimaryKeySelective(Wish record);

    int updateByPrimaryKey(Wish record);
}