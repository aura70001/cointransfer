package com.demo.cointransfer;

import com.demo.cointransfer.dto.coindeskapi.CoindeskApiOutputDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.demo.cointransfer.service.CoindeskApiService;

@SpringBootTest
class CointransferApplicationTests {
	@Autowired
	CoindeskApiService coindeskApiService;

	@Test
	void contextLoads() {
	}
}
