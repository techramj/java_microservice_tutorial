package com.learnjava.rest.webservice.restfulwebservices.controller;

import com.learnjava.rest.webservice.restfulwebservices.bean.User;
import com.learnjava.rest.webservice.restfulwebservices.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Resource
    public UserDao userDao;

    @GetMapping
    public List<User>  getUsers(){
        return userDao.findAll();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") Integer id){

        return userDao.findOne(id);
    }

    @PostMapping()
    public User addUser(@RequestBody User user){
       User newUser=userDao.save(user);
       return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        User newUser=userDao.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") Integer id){
        return userDao.delete(id);
    }


}
