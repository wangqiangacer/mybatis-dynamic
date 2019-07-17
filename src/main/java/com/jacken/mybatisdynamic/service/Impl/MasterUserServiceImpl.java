package com.jacken.mybatisdynamic.service.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jacken.mybatisdynamic.dao.UserDao;
import com.jacken.mybatisdynamic.entity.User;
import com.jacken.mybatisdynamic.service.MasterUserService;
import org.springframework.stereotype.Service;

@Service("MasterUserService")
@DS("master") //该注解标注在类上表示当前类所有方法都是操作master库
public class MasterUserServiceImpl extends ServiceImpl<UserDao, User> implements MasterUserService {
}
