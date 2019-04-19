package com.charles.controller;

import com.charles.facade.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-04
 * Time: 16:51
 */
@RestController
public class ApiController {

    private final ApiService  apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }
    @RequestMapping("/hello")
    public String helloFeign(){
        return apiService.hello();
    }
}
