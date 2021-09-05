package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @programe: changgou
 * @Description:
 * @Author: li shuai ming
 * @Create: 2021/9/5-22:09
 */
@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
/*
* 跨域：A域名访问B域名的数据
*     域名或者请求端口或者协议不一致的时候，就跨域了。
*     www.itheima.com   html  www.itcast.cn
*     www.iteima.com    html  www.iteima.com/user/list
*     www.itheima.com:18081  html  itheima.com:18082/user/list
*     https://www.itheima.com  html  http://www.itheima.com
 * */
public class BrandController {

    @Autowired
    private BrandService brandService;
    /*
    * 查询所有品牌信息
    * */
    @GetMapping
    public Result<List<Brand>> findAll(){

        List<Brand> brands =brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询品牌集合成功",brands);
    }
}
