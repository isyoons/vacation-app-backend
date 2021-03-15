package com.example.vacation.payload;

public class UserInfo {
    private Long id;
    private String username;
    private String name;
    private Double totalDays;
    private Double useDays;
    private Double leftDays;

    public UserInfo(Long id, String username, String name, Double totalDays, Double useDays, Double leftDays) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.totalDays = totalDays;
        this.useDays = useDays;
        this.leftDays = leftDays;
    }
    
    public UserInfo(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(Double totalDays) {
		this.totalDays = totalDays;
	}

	public Double getUseDays() {
		return useDays;
	}

	public void setUseDays(Double useDays) {
		this.useDays = useDays;
	}

	public Double getLeftDays() {
		return leftDays;
	}

	public void setLeftDays(Double leftDays) {
		this.leftDays = leftDays;
	}
}
