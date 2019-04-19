package com.charles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-04
 * Time: 13:50
 */
@RestController
public class HelloController {


    @Value("${server.port}")
    private int port;

    @GetMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("code", 0);
        resultMap.put("msg", "SUCCESS");
        resultMap.put("data", "端口:"+port);
        return resultMap;
    }

}
