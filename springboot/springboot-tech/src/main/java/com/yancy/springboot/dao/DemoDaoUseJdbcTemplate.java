package com.yancy.springboot.dao;

import com.yancy.springboot.bean.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by yancy on 2017/11/7.
 */
@Repository("demoDao1")
public class DemoDaoUseJdbcTemplate {

    @Autowired //自动装配模板
    private JdbcTemplate jdbcTemplate;
    /**
     * TODO 根据主键获取数据
     * @param id 主键
     * @return 实体对象
     */
    public Demo getById(Integer id) {
        String sql = "select * from Demo where id = ?";
        //获取数据映射
        RowMapper<Demo> mapper = new BeanPropertyRowMapper<Demo>();
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }
}
