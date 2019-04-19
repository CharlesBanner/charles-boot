package com.charles.mapper.test02;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-18
 * Time: 18:55
 */
@Mapper
public interface UserMapper2 {
    @Insert("insert into test_user(name,age) values(#{name},#{age})")
    void addUser(@Param("name")String name,@Param("age") int age);
}
