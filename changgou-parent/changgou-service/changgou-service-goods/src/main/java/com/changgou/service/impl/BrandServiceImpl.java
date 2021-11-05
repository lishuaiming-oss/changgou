package com.changgou.service.impl;


import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

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

    /**
     * @return * @return: null
     * @Description: 分页+查询
     * @Author: L
     * @Date: 2021/11/5 14:45
     * @Params * @param brand page,size:
     **/
    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //按条件查询 if !name=null 按名字搜索 ，if ！letter=null 按首字母搜索
        Example example = createExample(brand); //自定义搜索条件
        //使用通用Mapper进行数据查询
        List<Brand> brands = brandMapper.selectByExample(example);
        //封装到PageInfo
        return new PageInfo<Brand>(brands);
    }

    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        /*
        * 分页实现：PageHelper.startPage(page,size) 后面的查询紧跟集合查询
        *
        * */
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询，查询集合
        List<Brand> brands = brandMapper.selectAll();
        //封装 PageInfo<Brand> ——————》list--page
        return new PageInfo<Brand>(brands);
    }

    /*
    * 多条件搜索品牌信息
    * */
    @Override
    public List<Brand> findList(Brand brand) {
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }
    /*提取公共部分*/
    public Example createExample(Brand brand){
        //自定义条件搜索对象
        Example example=new Example(Brand.class); //参数为品牌对象的字节码文件
        Example.Criteria criteria = example.createCriteria(); //条件构造器

        if (brand != null){
            // Brand.name!=null 根据名字模糊查询 where name like '%华%'
            if (!StringUtil.isEmpty(brand.getName())){
                /*
                 *  1.Brand的属性名
                 *  2.占位数参数，搜索条件
                 * */
                criteria.andLike("name","%"+brand.getName()+"%"); //拼接SQL
            }
            // Brand.Ietter!=null 根据品牌的首字母搜索
            if (!StringUtil.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }
        return example;
    }

    /**
     * @return * @return: null
     * @Description: 根据ID删除品牌信息
     * @Author: L
     * @Date: 2021/11/3 15:04
     * @Params * @param id:
     **/
    @Override
    public void delete(Integer id) {
        /*
        * 通用Mapper做删除
        * */
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override


    /**
     * @Description: 查询所有品牌信息
     * @Author: L
     * @Date: 2021/10/25
     * @Params
     * @return java.util.List<com.changgou.goods.pojo.Brand>
     **/
    public List<Brand> findAll() {
        //通用Mapper的方法
       return brandMapper.selectAll();
    }


    /**
     * @return Brand
     * @Description:
     * @Author: L
     * @Date: 2021/10/25 14:46
     * @Params * @param :id
     **/

    public Brand findById(Integer id){
        return brandMapper.selectByPrimaryKey(id);
    }


    @Override
    /**
     * @Description: 增加品牌信息
     * @Author: L
     * @Date: 2021/10/26 10:29
     * @Params  * @param brand:
     * @return void
     **/
    public void add(Brand brand) {
        //insertSelective +tive会忽略空值
      brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        //使用通用Mapper方法 使用brandMapper.updateByPrimaryKeySelective(brand)，组装的SQL语句会忽略空值
        brandMapper.updateByPrimaryKeySelective(brand);
    }

}
