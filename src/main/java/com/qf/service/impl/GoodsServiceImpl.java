package com.qf.service.impl;

import com.qf.commom.BaseResponse;
import com.qf.dao.GoodsMapper;
import com.qf.pojo.Goods;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public BaseResponse findAll() {
        BaseResponse baseResponse = new BaseResponse();
        List<Goods> all = goodsMapper.findAll();
        if (all != null) {
            baseResponse.setData(all);
            baseResponse.setCode(200);
            baseResponse.setMessage("查询成功");
        }else {
            baseResponse.setCode(201);
            baseResponse.setMessage("查询失败");
        }
        return baseResponse;

    }

    @Override
    public BaseResponse findById(Integer id) {
        BaseResponse baseResponse=new BaseResponse();
        Goods byId=goodsMapper.findById(id);
        if (byId!=null){
            baseResponse.setData(byId);
            baseResponse.setCode(200);
            baseResponse.setMessage("查询成功");
        }else {
            baseResponse.setCode(201);
            baseResponse.setMessage("查询失败");
        }
        return baseResponse;
    }

    @Override
    public BaseResponse findAllHeat() {
        BaseResponse baseResponse=new BaseResponse();
        List<Goods> all=goodsMapper.findAllHeat();
        if (all!=null){
            baseResponse.setData(all);
            baseResponse.setCode(200);
            baseResponse.setMessage("查询成功");
        }else {
            baseResponse.setCode(201);
            baseResponse.setMessage("查询失败");
        }
        return baseResponse;
    }
}
