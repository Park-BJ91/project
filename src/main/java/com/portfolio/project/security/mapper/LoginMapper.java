package com.portfolio.project.security.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    public Map<String,String> loginCheck();
    
}
