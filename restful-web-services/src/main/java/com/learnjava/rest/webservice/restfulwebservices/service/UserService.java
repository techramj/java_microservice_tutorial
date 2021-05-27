package com.learnjava.rest.webservice.restfulwebservices.service;

import com.learnjava.rest.webservice.restfulwebservices.bean.User;
import com.learnjava.rest.webservice.restfulwebservices.dao.UserDao;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService {

    @Resource
    private UserDao userDao;

    public User addUser(User user){
        return userDao.save(user);
    }

    public User updateUser(User user){
        return userDao.save(user);
    }

    public List<User>  getAllUser(){
        return userDao.findAll();
    }

    public User findUser(int id){
        return userDao.findOne(id);
    }

    public User deleteUser(int id){
        return userDao.delete(id);
    }

}
