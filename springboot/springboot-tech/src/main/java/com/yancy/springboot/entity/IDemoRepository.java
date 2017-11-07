package com.yancy.springboot.entity;

import com.yancy.springboot.bean.Demo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yancy on 2017/11/7.
 */
public interface IDemoRepository extends CrudRepository<Demo, Integer>{

}
