package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @programe: changgou
 * @Description: 商品微服务启动类
 * @Author: li shuai ming
 * @Create: 2021/9/1-22:59
 */
@SpringBootApplication
@EnableEurekaClient    //开启服务
@MapperScan(basePackages ={"com.changgou.dao"} )
/*
*  开启通用Mapper的包扫描
*  引用包名mapper tk.mybatis.spring.annotation.MapperScan;
* */

public class GoodsAppliation {
    public static void main(String[] args) {
        SpringApplication.run(GoodsAppliation.class,args);
    }
}
