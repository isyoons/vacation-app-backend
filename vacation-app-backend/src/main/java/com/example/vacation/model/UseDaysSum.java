package com.example.vacation.model;

public class UseDaysSum {
    private Long vacationId;
    private Double useDaysSum;

    public UseDaysSum(Long vacationId, Double useDaysSum) {
        this.vacationId = vacationId;
        this.useDaysSum = useDaysSum;
    }

	public Long getVacationId() {
		return vacationId;
	}

	public void setVacationId(Long vacationId) {
		this.vacationId = vacationId;
	}

	public Double getUseDaysSum() {
		return useDaysSum;
	}

	public void setUseDaysSum(Double useDaysSum) {
		this.useDaysSum = useDaysSum;
	}

    
}

