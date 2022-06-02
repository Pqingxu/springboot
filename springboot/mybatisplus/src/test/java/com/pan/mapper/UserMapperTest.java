package com.pan.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pan.entry.pojo.User;
import com.pan.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/18
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserService userService;

    @Test
    public void demo1(){
        User addUser = new User();
        addUser.setUsername("addUser");
        addUser.setAge(100);
        addUser.setUuid("005");

        //int insert = mapper.insert(addUser);
        //System.out.println("addUser -->" + insert);

        User user = mapper.selectById(5);
        System.out.println("mapper.selectById(5)--->"+  user);
        user.setUuid("update-->" + user.getUuid());
        mapper.updateById(user);



        List<User> users = mapper.selectList(null);
        users.forEach(each->{
            System.out.println(each.toString());
        });
    }

    @Test
    public void  demo2(){
        User user = mapper.mySelectUserById(Long.valueOf(5));
        System.out.println(user);
    }

    @Test
    public void demo3(){
        int count = userService.count();
        System.out.println("userService.count()--->" + count);
    }

    @Test
    public void demo4(){
        List<User> userList = new ArrayList<>();
        for(int i=0; i<10 ;i++){
            User user = new User();
            user.setId(Long.valueOf(i));
            user.setUuid("011" + i);
            user.setUsername("name" + i);
            user.setAge(i);
            userList.add(user);
        }
        userService.saveOrUpdateBatch(userList,2);
        System.out.println("导入完毕");
    }

    @Test
    public void demo5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username","1")
                .between("id",1,20);
        List<User> userList = mapper.selectList(wrapper);
        userList.forEach(each->{
            System.out.println(each.toString());
        });
    }

    @Test
    public void demo6(){
        Page<User> userPage = new Page<>(2,3);
        Page<User> userPage1 = mapper.selectPage(userPage, null);
        List<User> list = userPage.getRecords();
        list.forEach(each->{
            System.out.println(each.toString());
        });

    }

}
