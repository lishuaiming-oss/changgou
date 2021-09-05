package com.changgou.service.impl;


import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @programe: changgou
 * @Description: 逻辑层
 * @Author: li shuai ming
 * @Create: 2021/9/5-21:48
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Override

    /*查询所有品牌结果*/
    public List<Brand> findAll() {
        //通用Mapper的方法
       return brandMapper.selectAll();
    }

}
