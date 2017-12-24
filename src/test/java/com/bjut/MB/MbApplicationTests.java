package com.bjut.MB;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.dao.OrderDao;
import com.bjut.MB.model.Order;
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

	}

}
