package com.plan.entity;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PLAN_MASTER")
public class Plan implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plan_id;
	@Column(name="plan_name",unique = true)
	private String planName;
	private String status;
	private String comments;
	private Date planStartDate;
	private Date planEndDate;
	@CreationTimestamp
	@Column(name="CREATED_DATE",updatable = false)
	private Date createdDate;
	@Column(name="UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	private Date updatedDate;
	private Date createdBy;
	private Date updatedBy;
	
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Plan(Integer plan_id, String planName, String status, String comments) {
		super();
		this.plan_id = plan_id;
		this.planName = planName;
		this.status = status;
		this.comments = comments;
//		this.planStartDate = planStartDate;
//		this.planEndDate = planEndDate;
//		this.createdDate = createdDate;
//		this.updatedDate = updatedDate;
//		this.createdBy = createdBy;
//		this.updatedBy = updatedBy;
	}
	public Plan() {
		super();
	}
	@Override
	public String toString() {
		return "Plan [plan_id=" + plan_id + ", planName=" + planName + ", status=" + status + ", comments=" + comments
				+ ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}
	
}
