package com.example.vacation.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.vacation.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vacation")
public class Vacation extends DateAudit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userAnnualId;
	private String vacationGb;
	private String startDt;
	private String endDt;
	private Double useDays;
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserAnnualId() {
		return userAnnualId;
	}

	public void setUserAnnualId(Long userAnnualId) {
		this.userAnnualId = userAnnualId;
	}

	public String getVacationGb() {
		return vacationGb;
	}

	public void setVacationGb(String vacationGb) {
		this.vacationGb = vacationGb;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public Double getUseDays() {
		return useDays;
	}

	public void setUseDays(Double useDays) {
		this.useDays = useDays;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
