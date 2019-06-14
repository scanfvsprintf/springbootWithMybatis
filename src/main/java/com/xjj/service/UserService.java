package com.xjj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjj.mapper.UserMapper;
import com.xjj.pojo.*;

@Service
@Transactional
public class UserService {
	@Resource
	UserMapper userMapper;
	public List<User> getUsers(){
		return userMapper.getUsers();
	}
}
