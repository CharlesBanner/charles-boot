package com.charles.controller;

import com.charles.config.DistributedLockHandler;
import com.charles.model.User;
import com.charles.service.UserService;
import com.charles.util.AquiredLockWorker;
import com.charles.util.DistributedLocker;
import com.charles.util.Lock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-18
 * Time: 13:48
 */
@RestController
public class HelloController {

    @Autowired
    private DistributedLockHandler distributedLockHandler;

    @Autowired
    private DistributedLocker distributedLocker;
    @Autowired
    private UserService userService;


    @RequestMapping("index")
    public String index(){
        Lock lock=new Lock("lynn","min");
        if(distributedLockHandler.tryLock(lock)){
            try {
                //为了演示锁的效果，这里睡眠5000毫秒
                System.out.println("执行方法");
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            distributedLockHandler.releaseLock(lock);
        }
        return "hello world!";
    }

    @RequestMapping("index2")
    public String index2()throws Exception{
        distributedLocker.lock("test",new AquiredLockWorker<Object>() {

            @Override
            public Object invokeAfterLockAquire() {
                try {
                    System.out.println("执行方法！");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }

        });
        return "hello world!";
    }

    @RequestMapping("addUser")
    public String addUser()throws Exception{
        User user = new User();
        user.setName(String.valueOf(System.currentTimeMillis()));
        user.setAge(20);
        userService.addUser( user);
        return "hello world!";
    }
}
