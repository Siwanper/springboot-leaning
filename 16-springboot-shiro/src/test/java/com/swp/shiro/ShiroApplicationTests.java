package com.swp.shiro;

import com.swp.shiro.repository.UserRepository;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {

	@Autowired
	private UserRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void md5(){
		String algorithmName = "MD5";
		String password = "123456";
		SimpleHash simpleHash = new SimpleHash(algorithmName, password);
		System.out.println(simpleHash.toString());
	}

	@Test
	public void md5WithSalt(){
		String algorithmName = "MD5";
		String password = "123456";
		String salt = "guest8d78869f470951332959580424d4bf4f";
		int hashIterations = 2;
		SimpleHash simpleHash = new SimpleHash(algorithmName, password, salt, hashIterations);
		System.out.println(simpleHash.toString());
	}




}
