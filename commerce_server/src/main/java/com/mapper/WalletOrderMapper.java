package com.mapper;

import com.pojo.WalletOrder;
import com.pojo.WalletOrderDetail;
import com.pojo.WalletOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WalletOrderMapper {

    List<WalletOrderDetail> findWalletOrderDetaail();


    long countByExample(WalletOrderExample example);

    int deleteByExample(WalletOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WalletOrder record);

    int insertSelective(WalletOrder record);

    List<WalletOrder> selectByExample(WalletOrderExample example);

    WalletOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WalletOrder record, @Param("example") WalletOrderExample example);

    int updateByExample(@Param("record") WalletOrder record, @Param("example") WalletOrderExample example);

    int updateByPrimaryKeySelective(WalletOrder record);

    int updateByPrimaryKey(WalletOrder record);
}