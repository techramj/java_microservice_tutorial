package com.kale.trade.entity;

import com.kale.trade.generator.PrefixGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@NamedQuery(name = "get_all_company", query = "select c from Company c")
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq_generator")
    @GenericGenerator(
            name = "company_seq_generator",
            strategy = "com.kale.trade.generator.PrefixGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "seq_company_id"),
                    @Parameter(name = PrefixGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PrefixGenerator.VALUE_PREFIX_PARAMETER, value = "C"),
            })
    private String id;
    private String name;

    public Company(){}

    public Company(String name){
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
