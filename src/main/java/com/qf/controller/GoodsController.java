package com.qf.controller;

import com.qf.commom.BaseResponse;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public BaseResponse findAll(){
        return  goodsService.findAll();
    }
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public  BaseResponse findById(@RequestParam Integer id){
        return goodsService.findById(id);
    }
    @RequestMapping(value = "/findAllHeat",method = RequestMethod.GET)
    public BaseResponse findAllHeat(){
        return goodsService.findAllHeat();
    }
}
