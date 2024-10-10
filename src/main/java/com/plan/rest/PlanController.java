package com.plan.rest;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.plan.dto.PlanDTO;
import com.plan.entity.Plan;
import com.plan.exception.PlanNotFoundException;
import com.plan.service.PlanService;

@RestController
public class PlanController {
	
	@Autowired
	private PlanService planService;
	
	private Logger logger=LoggerFactory.getLogger(PlanController.class);
	
	@PostMapping("/saveplan")
	public ResponseEntity<String> save(@RequestHeader("his-correlation-id") String correlationId, @RequestBody PlanDTO planDTO){
	    logger.info("saved the plan with correlation id : "+correlationId);
		String saved = planService.savePlan(planDTO);
		return new ResponseEntity<String>(saved,HttpStatus.OK);
	}
	
	@PutMapping("/updateplan/{id}")
	public ResponseEntity<String> update(@RequestHeader("his-correlation-id") String correlationId,@RequestBody Plan plan,@PathVariable Integer id) throws PlanNotFoundException{
		logger.info("update the plan with correlation id :  "+correlationId);
		String message = planService.updatePlan(plan, id);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	  
	@GetMapping("/plan/{id}")
	public ResponseEntity<Plan> getPlanById(@RequestHeader("his-correlation-id") String correlationId,@PathVariable Integer id){
		logger.info("Getting the plan Based on id : "+correlationId);
		Plan plan = planService.getPlan(id);
		return new ResponseEntity<Plan>(plan,HttpStatus.OK);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getPlans(@RequestHeader("his-correlation-id") String correlationId){
		logger.info("getting plans from plan table "+correlationId);
		List<Plan> plans = planService.getPlans();
		return new ResponseEntity<List<Plan>>(plans,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePlan(@RequestHeader("his-correlation-id") String correlationId,@PathVariable Integer id) throws PlanNotFoundException{
		logger.info("Delete the plan "+correlationId);
		String message = planService.deletePlan(id);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
