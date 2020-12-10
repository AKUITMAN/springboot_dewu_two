package com.qf.dao;

import com.qf.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> findAll();
    Goods findById(@Param("id")Integer id);
    List<Goods> findAllHeat();

}
