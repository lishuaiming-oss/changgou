package com.changgou.dao;

import com.changgou.goods.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

/**
 * @programe: changgou
 * @Description: 品牌dao接口
 * @Author: li shuai ming
 * @Create: 2021/9/2-20:10
 * DAO使用通用Mapper,Dao接口需要继承import tk.mybatis.mapper.common.Mapper;
 *    增加数据：调用Mapper.insert()方法，增删改查类似
 */
public interface BrandMapper extends Mapper<Brand> {
}
