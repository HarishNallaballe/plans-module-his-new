package com.plan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.plan.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer>{
	
	@Query(value = "select * from plan_master where plan_name=:planName",nativeQuery = true)
	public Plan checkUnique(String planName);

}
