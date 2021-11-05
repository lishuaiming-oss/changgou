package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @programe: changgou
 * @Description:
 * @Author: li shuai ming
 * @Create: 2021/9/5-22:07
 */

public interface BrandService {

    /*
    *  分页查询
    *  @params page ,size
    * */
    PageInfo<Brand> findPage(Integer page, Integer size);

    /*
    *  多条件搜索品牌方法
    * @params Brand brand
    *
    * */
     List<Brand> findList(Brand brand);

    /*
    *  根据ID删除
    *  @param id
    * */
    void delete(Integer id);
    /*
    * 查询所有
    * */
    List<Brand> findAll();
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Brand findById(Integer id);
    /*
    * 增加品牌信息
    *
    * */
    void add(Brand brand);

    /*
    *  根据ID修改品牌信息
    *
    * */
    void update(Brand brand);
}
