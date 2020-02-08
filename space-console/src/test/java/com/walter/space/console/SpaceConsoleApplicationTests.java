package com.walter.space.console;

import com.walter.space.console.dao.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpaceConsoleApplicationTests {
@Autowired
private AdminMapper adminMapper;
	@Test
	public void contextLoads() {
	}
}
