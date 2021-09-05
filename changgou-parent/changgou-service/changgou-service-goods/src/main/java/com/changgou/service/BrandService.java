package com.changgou.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;

/**
 * @programe: changgou
 * @Description:
 * @Author: li shuai ming
 * @Create: 2021/9/5-22:07
 */

public interface BrandService {
    /*
    * 查询所有
    * */
    List<Brand> findAll();
}
