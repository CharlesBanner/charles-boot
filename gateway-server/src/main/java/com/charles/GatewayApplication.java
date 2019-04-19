package com.charles;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * Created with IntelliJ IDEA.
 * Description: 网关服务
 *
 * @author: GanZiB
 * Date: 2019-04-03
 * Time: 22:44
 */
@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }

}
