package com.changou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @programe: changgou
 * @Description: Eureka网关启动类
 * @Author: li shuai ming
 * @Create: 2021/8/31-22:28
 */
@SpringBootApplication
@EnableEurekaServer   //开启Eureka服务
public class EurekaApplication {

    
    /*
    *
    * 加载启动类，已启动类为springboot的配置标准
    * */
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
