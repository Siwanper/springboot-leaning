package com.swp.quartz2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Quartz2ApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext applicationContext;

	@Before
	public void before(){
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void saveGood() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/good/save")
				.param("name","西红柿")
				.param("unit","斤")
				.param("price","12.88")
		)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andReturn();
		result.getResponse().setCharacterEncoding("UTF-8");
		System.out.println(result.getResponse().getContentAsString());

	}

	@Test
	public void seckillGood() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/good/seckill")
				.param("goodId","14")
		)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andReturn();
		result.getResponse().setCharacterEncoding("UTF-8");
		System.out.println(result.getResponse().getContentAsString());

	}


}

