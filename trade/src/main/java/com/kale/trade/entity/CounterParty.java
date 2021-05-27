package com.kale.trade.entity;

import com.kale.trade.generator.PrefixGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CounterParty   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "counter_seq_generator")
    @GenericGenerator(
            name = "counter_seq_generator",
            strategy = "com.kale.trade.generator.PrefixGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "seq_counter_party_id"),
                    @Parameter(name = PrefixGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PrefixGenerator.VALUE_PREFIX_PARAMETER, value = "CP-"),
            })
    private String id;

    private String name;

    public CounterParty(){}

    public CounterParty(String name){
        this.name=name;
    }

}
