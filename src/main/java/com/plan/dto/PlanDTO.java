package com.plan.dto;

import java.sql.Date;

public class PlanDTO {
	
	private Integer plan_id;
	private String planName;
	private String status;
	private String comments;
	private Date planStartDate;
	private Date planEndDate;
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}
	public Date getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}
	
	public PlanDTO(Integer plan_id, String planName, String status, String comments) {
		super();
		this.plan_id = plan_id;
		this.planName = planName;
		this.status = status;
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "PlanDTO [plan_id=" + plan_id + ", planName=" + planName + ", status=" + status + ", comments="
				+ comments + ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + "]";
	}
	
}
