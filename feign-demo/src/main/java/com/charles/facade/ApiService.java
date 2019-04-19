package com.charles.facade;

import com.charles.facade.hystrix.ApiServiceError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-04
 * Time: 14:55
 */
@FeignClient(value = "eureka-client-demo",fallback = ApiServiceError.class)
public interface ApiService {

    /**
     * OpenFeign demo
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
}
