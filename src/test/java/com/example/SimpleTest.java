package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.dao.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void select() {
		List<User> users = userMapper.selectList(null);
		Assert.assertEquals(5,users.size());
		users.forEach(System.out::println);

	}

	@Test
	public void insert(){
		User user = new User();
		user.setAge(30);
		user.setName("Elliot");
		user.setManagerId(1088248166370832385L);
		user.setCreateTime(LocalDateTime.now());
		int rows = userMapper.insert(user);
		System.out.println("影响列数: "+ rows);
	}

	@Test
	public void selectByWrapper(){
		//QueryWrapper<Object> query = Wrappers.query();
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("name","雨").lt("age",40);
		List<User> users = userMapper.selectList(queryWrapper);
		users.forEach(System.out::println);
	}

	@Test
	public void selectByWrapper2(){
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}","2019-02-14")
				    .inSql("manager_id","select id from user where name like '王%'");
		List<User> users = userMapper.selectList(queryWrapper);
		users.forEach(System.out::println);
	}

	@Test
	public void selectByWrapper3(){
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.and(wq->wq.lt("age",40).or().isNotNull("email"));
		List<User> users = userMapper.selectList(queryWrapper);
		users.forEach(System.out::println);
	}
}
