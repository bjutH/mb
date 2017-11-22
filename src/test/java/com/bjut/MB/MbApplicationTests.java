package com.bjut.MB;

import com.bjut.MB.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MbApplicationTests {

	@Autowired
	private OrderDao orderDao;

	@Test
	public void contextLoads() {
		orderDao.addItem("123","gongxu","c:/file/test");
		orderDao.updateItem("123","lisan","gongxu","haha","ps");
	}

}
