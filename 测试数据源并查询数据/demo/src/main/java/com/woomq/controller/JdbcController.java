package com.woomq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 从student中查询所有的信息
 */
@Controller
public class JdbcController {
    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;

    /**
     * 没有使用实体类 返回的数据信息使用Map接受
     * @return
     */
    @GetMapping("/studentList")
    @ResponseBody
    public List<Map<String,Object>> studentList(){
        System.out.println("hello");
        String sql = "select * from student";
        System.out.println("hello2");
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
        return maps;
    }
}
