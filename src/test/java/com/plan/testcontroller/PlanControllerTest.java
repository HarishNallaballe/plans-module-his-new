package com.plan.testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.plan.entity.Plan;
import com.plan.rest.PlanController;
import com.plan.service.PlanService;
import com.plan.service.PlanServiceImpl;

@WebMvcTest(value = PlanController.class)
public class PlanControllerTest {

	@MockBean
	private PlanServiceImpl planService;
	
	@InjectMocks
	private PlanController planController;
	
	@Autowired
	private MockMvc mockMvc;
	
	 void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	
		/*
		 * @Test public void getPlanByIdTest() throws Exception { Plan plan = new
		 * Plan(1,"SNAP","active","SNAP");
		 * //when(planService.getPlan(1)).thenReturn(plan);
		 * 
		 * int status =
		 * mockMvc.perform(get("/plan/{id}",2)).andExpect(status().isOk()).andReturn().
		 * getResponse().getStatus();
		 * 
		 * assertEquals(200, status);
		 * 
		 * }
		 */
	
}
