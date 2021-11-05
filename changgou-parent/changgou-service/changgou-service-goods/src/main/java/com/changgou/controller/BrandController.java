package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    *  分页查询
    *  @Params page size
    *
    * */
    @GetMapping(value = "/search/{page}/{size}")
   public Result<PageInfo<Brand>> findPage(@PathVariable Integer page,@PathVariable Integer size){
        //分页查询
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询成功",pageInfo);
    }

    /*
    * 多条件查询品牌信息
    * */
    @PostMapping(value = "/search")
     public Result<List<Brand>> findList(@RequestBody Brand brand){
        //调用逻辑层实例方法
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"多条件查询品牌信息成功",list);
    }

    /*
    *  根据ID删除品牌信息
    *  @Params
    */
    @DeleteMapping("/{id}")
    public Result  delete(@PathVariable(value = "id") Integer id){
        brandService.delete(id);
      return new Result<Brand>(true,StatusCode.OK,"品牌信息删除成功");
    }
    /*
    * 查询所有品牌信息
    * */
    @GetMapping
    public Result<List<Brand>> findAll(){

        List<Brand> brands =brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询品牌集合成功",brands);
    }

    /*
    * 根据id查询品牌信息
    *
    * */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"根据ID查询品牌信息成功",brand);
    }
    /*
    *
    * 增加品牌信息
    * @Params brand
    * */
    @PostMapping
    public Result  addBrand(@RequestBody Brand brand){
           brandService.add(brand);
        return new Result<Brand>(true,StatusCode.OK,"品牌信息增加成功");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable(value = "id") Integer id, @RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result<Brand>(true,StatusCode.OK,"品牌信息修改成功");
    }

}
