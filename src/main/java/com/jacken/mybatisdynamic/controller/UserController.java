package com.jacken.mybatisdynamic.controller;
import com.jacken.mybatisdynamic.entity.User;
import com.jacken.mybatisdynamic.service.MasterUserService;
import com.jacken.mybatisdynamic.service.SlaveUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MasterUserService masterUserService;
    @Autowired
    private SlaveUserService slaveUserService;

    /**
     * 多数据源测试 -- 分条件操作不同数据源
     * @param name 名字
     * @author wangqiang
     * @date 14:32 2019/7/17
     */
    @RequestMapping(value = "/addOneUser")
    public void addOneUser(@RequestParam("name") String name){
        User user = new User();
        String s = System.currentTimeMillis() + "";
        user.setId(Long.parseLong(s.substring(6,13)));
        user.setName(name);
        user.setAge(20);
        user.setEmail("www.baidu.com");
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(name);
        if(m.find()){
            masterUserService.save(user);
        }else {
            slaveUserService.save(user);
        }
    }
}
