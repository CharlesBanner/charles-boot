package com.charles.service;

import com.charles.mapper.test01.UserMapper1;
import com.charles.mapper.test02.UserMapper2;
import com.charles.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-18
 * Time: 18:57
 */
@Service
public class UserService {

    @Autowired
    private UserMapper1 userMapper1;
    @Autowired
    private UserMapper2 userMapper2;

    @Transactional(rollbackFor = Exception.class)
    public void addUser(User user)throws Exception{
        userMapper1.addUser(user.getName(),user.getAge());
        userMapper2.addUser(user.getName(),user.getAge());
        System.out.println(user.getName()+user.getAge());
    }
}
