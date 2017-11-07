package com.yancy.springboot.bean;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by yancy on 2017/11/7.
 */
@Entity  //加入这个注解，Demo就会持久化，在这里没有对@Table进行配置
@Table(name="DEMO", schema="ROOT")
public class Demo {

    @Id @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
