package com.plan.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plan.constants.AppConstants;
import com.plan.dto.PlanDTO;
import com.plan.entity.Plan;
import com.plan.exception.PlanNotFoundException;
import com.plan.repo.PlanRepository;


@Service
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	private PlanRepository repo;
	
	private Logger logger=LoggerFactory.getLogger(PlanServiceImpl.class);

	@Override
	public String savePlan(PlanDTO planDTO) {
		Plan plan = new Plan();
		BeanUtils.copyProperties(planDTO, plan);
		Plan unique = repo.checkUnique(plan.getPlanName());
		if(unique != null) {
			logger.info("PlanName must be Unique");
		return AppConstants.DUPLICATE_PLANNAME;
		}
		
		repo.save(plan);
		logger.info("Plan Saved Succesfully");
		return AppConstants.PLAN_SAVED_SUCCESSFULLY;
	}
	
	public String updatePlan(Plan plan,Integer id) throws PlanNotFoundException {
		 Plan savePlan = repo.findById(id).orElseThrow(()->new PlanNotFoundException("Plan Not found with given planId : "+id));
		 if(savePlan!=null) {
			savePlan.setComments(plan.getComments());
			savePlan.setPlanEndDate(plan.getPlanEndDate());
			savePlan.setPlanName(plan.getPlanName());
			savePlan.setPlanStartDate(plan.getPlanStartDate());
			savePlan.setStatus(plan.getStatus());
			repo.save(savePlan);
			logger.info("Plan saved successfully : "+savePlan);
			return AppConstants.PLAN_SAVED_SUCCESSFULLY;
	     }
		 logger.info("Plan Not saved succesfully");
		return AppConstants.PLAN_NOT_SAVED_SUCCESSFULLY;
	}
	
	public Plan getPlan(Integer id) {
		try {
			logger.info("getting the plan details for the id : "+id);
	       return repo.findById(id).orElseThrow(()-> new PlanNotFoundException("Plan Not gound with given planId"+id)); 
		}catch (Exception e) {
			logger.info("getting exception while fetching the plan details "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Plan> getPlans(){
		logger.info("Fetching Plan details from the db");
		return repo.findAll();
	}
	
	public String deletePlan(Integer id) throws PlanNotFoundException {
		
		//Plan plan = repo.findById(id).orElseThrow(()-> new PlanNotFoundException("Plan Not gound with given planId : "+id));
		try {
		logger.info("Plan Deleted Succesfully");
	    repo.deleteById(id);
		return AppConstants.PLAN_DELETED_SUCCESSFULLY;
		}catch (Exception e) {
	        logger.info("Plan Deletion Failed : "+e.getMessage());
			e.printStackTrace();
		}
		return AppConstants.PLAN_NOT_DELETED;
	}

//	@Override
//	public Plan checkUnique(String planName) {
//		Plan checkUnique = repo.checkUnique(planName);
//		if(checkUnique!=null) {
//			return checkUnique;
//		}
//		return null;
//	}

}
