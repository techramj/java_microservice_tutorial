package com.learnjava.rest.webservice.restfulwebservices.dao;

import com.learnjava.rest.webservice.restfulwebservices.bean.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Transactional(isolation = Isolation.DEFAULT )
public class UserDao {

    private static List<User> users=new ArrayList<>();
    private static int userCount=3;

    static{
        users.add(new User(1,"jack",new Date()));
        users.add(new User(2,"Adam",new Date()));
        users.add(new User(3,"John",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Optional<User> optionalUser = users.stream().filter(a -> a.getId() == id).findAny();
        if(optionalUser.isPresent()){
           return optionalUser.get();
        }
        return null;
    }

    public User save(User user){
        if(user.getId()==null){
            user.setId(++userCount);
            users.add(user);
        }else{
            users=users.stream().map(a->a.getId()==user.getId()?user:a).collect(Collectors.toList());
        }
        return user;
    }

    public User delete(int id){
        ListIterator<User> itr=users.listIterator();
        while(itr.hasNext()){
            User user=itr.next();
            if(user.getId()==id){
                itr.remove();;
                return user;
            }
        }
        return null;

    }


}

