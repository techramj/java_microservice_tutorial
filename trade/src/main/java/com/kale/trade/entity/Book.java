package com.kale.trade.entity;

import com.kale.trade.generator.PrefixGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@NamedQuery(name = "get_all_book", query = "select b from Book b")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_generator")
    @GenericGenerator(
            name = "book_seq_generator",
            strategy = "com.kale.trade.generator.PrefixGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "seq_book_id"),
                    @Parameter(name = PrefixGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PrefixGenerator.VALUE_PREFIX_PARAMETER, value = "B"),
                    })
    private String id ;
    private String name;

    public Book(){}

    public Book(String name){
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
