package com.plan.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.plan.dto.PlanDTO;
import com.plan.entity.Plan;
import com.plan.exception.PlanNotFoundException;

public interface PlanService {

	public String savePlan(PlanDTO planDTO);
	
	public String updatePlan(Plan plan,Integer id) throws PlanNotFoundException;
	
	public Plan getPlan(Integer id);
	
	public List<Plan> getPlans();
	
	public String deletePlan(Integer id) throws PlanNotFoundException;

}
