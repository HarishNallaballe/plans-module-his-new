package com.plan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import com.plan.dto.PlanDTO;
import com.plan.entity.Plan;
import com.plan.exception.PlanNotFoundException;
import com.plan.repo.PlanRepository;

public class PlanServiceTest {
	
	@Mock
	private PlanRepository repo;
	
	@InjectMocks
	private PlanServiceImpl planService;

	 @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);  // Initializes the @Mock and @InjectMocks
	    }
	 
	 @Test
	 void savePlanTest() {
		 String planName="SNAP";
		 PlanDTO dto=new PlanDTO(1,"SNAP","active","snap");
		 Plan plan = new Plan();
		 BeanUtils.copyProperties(dto, plan);
		 when(repo.save(Mockito.any(Plan.class))).thenReturn(plan);
		 when(repo.checkUnique(planName)).thenReturn(plan);
		 String savePlan = planService.savePlan(dto);
		 Assertions.assertThat(savePlan).isNotNull(); 
	 }
	 
	 @Test
	 public void save1PlanTest() {
		 PlanDTO dto=new PlanDTO(2,"SNAP","active","snap");
		 Plan plan = new Plan();
		 BeanUtils.copyProperties(dto, plan);
		 when(repo.save(plan)).thenReturn(plan);
		 String savePlan = planService.savePlan(dto);
		 assertThat(savePlan).isEqualTo("Plan Saved SuccesFully");
	 }
	 
	 @Test
	 public void updatePlanTest() throws PlanNotFoundException {
		 Plan plan = new Plan(1,"SNAP","active","snap");
		 when(repo.save(plan)).thenReturn(plan);
		 plan.setPlanName("CCAP");
		 String updatePlan = planService.updatePlan(plan, 1);
		 assertThat(updatePlan).isEqualTo("Plan Saved SuccesFully");
	 }
	 @Test
	 void getPlansTest() {
		 List<Plan> list=Arrays.asList(new Plan(1,"SNAP","active","snap"),
				 					new Plan(2,"CCAP","active","snap"),
				 					new Plan(3,"Medicare","active","snap"));
		 
		 when(repo.findAll()).thenReturn(list);
		 List<Plan> plans = planService.getPlans();
		 assertEquals(3, plans.size());
	 }
	 
	 
	 @Test
	 void testPlanById_planExists() {
		 Plan plan = new Plan(1,"SNAP","active","snap");
		 
		 when(repo.findById(1)).thenReturn(Optional.of(plan));		 
		 Plan plan2 = planService.getPlan(1);
		 System.out.println(plan2);
		 assertEquals("SNAP", plan2.getPlanName());
		 verify(repo).findById(1);
	 }
	 
	 @Test
	 void planGetById_PlanDoesNotExist() {
		 when(repo.findById(1)).thenReturn(Optional.empty());
		 Plan plan = planService.getPlan(1);
		 assertFalse(plan!=null);
	 }
	 
	 @Test
	 void deletePlanTest() throws PlanNotFoundException {
		 Plan plan = new Plan(1,"SNAP","active","snap");
		planService.deletePlan(1);
		verify(repo, times(1)).deleteById(1);
	 }
}
