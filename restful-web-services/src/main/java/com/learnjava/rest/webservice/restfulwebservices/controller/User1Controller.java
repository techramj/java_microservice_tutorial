package com.learnjava.rest.webservice.restfulwebservices.controller;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learnjava.rest.webservice.restfulwebservices.bean.User;
import com.learnjava.rest.webservice.restfulwebservices.exception.UserNotFoundException;
import com.learnjava.rest.webservice.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users1")
public class User1Controller {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUser();
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser=userService.addUser(user);
        //return the status CREATED
        //user/4

        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
       // ResponseEntity<User> entity=new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        return ResponseEntity.created(uri).build() ;

    }


    @GetMapping("/{id}")
    public EntityModel<User> findUser(@PathVariable("id") Integer id){
        User user= userService.findUser(id);
        //HATEOAS
        if(user==null){
            throw new UserNotFoundException("No user with id: "+id);
        }


        EntityModel<User> resource=EntityModel.of(user);
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.
                linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());

        resource.add(linkTo.withRel("all-Users"));

        return resource;
    }


    @PutMapping
    public User updateUser(@RequestBody User user){
        User newUser=userService.updateUser(user);
        return user;
    }


    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") Integer id){
        User user= userService.deleteUser(id);
        if(user==null){
            throw new UserNotFoundException("No user with id: "+id);
        }

        return user;
    }

    public MappingJacksonValue userFiltering(String filterId,Object bean,String...filterFields){
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept(filterFields);

        FilterProvider filterProvider=new SimpleFilterProvider().addFilter(filterId,filter);
        MappingJacksonValue mapping =  new MappingJacksonValue(bean);
        mapping.setFilters(filterProvider);
        return mapping;


    }

    @GetMapping(value = "/filter")
    public MappingJacksonValue getUsers1(){
        List<User> allUser = userService.getAllUser();


        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("id","name");

        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("userFilter",filter);
        MappingJacksonValue mapping =  new MappingJacksonValue(allUser);

        mapping.setFilters(filterProvider);
        return mapping;
    }




}
