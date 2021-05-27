package com.learnjava.rest.webservice.restfulwebservices.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

@NamedQuery(name = "get_all_java_course",query = "select c from Course c where c.name like '%Java%'")
@NamedQuery(name = "get_all_course", query = "select c from Course c")
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews=new ArrayList<>();


    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime  createDate;

    public Course(Long id,String name){
        this.id=id;
        this.name=name;
    }


    public Course(String name){
        this.name=name;
    }

    public void addReview(Review review){
        reviews.add(review);
    }

    public void deleteReview(Review review){
        reviews.remove(review);
    }




}
