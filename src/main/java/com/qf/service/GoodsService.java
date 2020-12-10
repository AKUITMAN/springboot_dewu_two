package com.qf.service;

import com.qf.commom.BaseResponse;
import com.qf.pojo.Goods;

import javax.servlet.http.HttpServletRequest;

public interface GoodsService {
    BaseResponse findAll();
    BaseResponse findById(Integer id);
    BaseResponse findAllHeat();
}
