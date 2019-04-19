package com.charles.facade.hystrix;

import org.springframework.stereotype.Component;

import com.charles.facade.ApiService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-04
 * Time: 16:49
 */
@Component
public class ApiServiceError implements ApiService {
    @Override
    public String hello() {
        return "服务发生故障！";
    }
    
}
