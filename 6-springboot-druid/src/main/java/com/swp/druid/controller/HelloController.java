package com.swp.druid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-10 12:05 PM
 */

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate1;

    @RequestMapping("/hello")
    public List<Map<String, Object>> hello(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM tb_user ", new Object[]{});
        return list;
    }

    @RequestMapping("/hello1")
    public List<Map<String, Object>> hello1(){
        List<Map<String, Object>> list = jdbcTemplate1.queryForList("SELECT * FROM TB_PRODUCT ", new Object[]{});
        return list;
    }

}
