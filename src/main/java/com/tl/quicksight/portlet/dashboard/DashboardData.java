package com.tl.quicksight.portlet.dashboard;

public class DashboardData {
	private String dashboardType;
	public DashboardData(String dashboardType, String dashboardId) {
		super();
		this.dashboardType = dashboardType;
		this.dashboardId = dashboardId;
	}

	private String dashboardId;
	
	public DashboardData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getDashboardId() {
		return dashboardId;
	}
	public void setDashboardId(String dashboardId) {
		this.dashboardId = dashboardId;
	}

	public String getDashboardType() {
		return dashboardType;
	}

	public void setDashboardType(String dashboardType) {
		this.dashboardType = dashboardType;
	}
	
	

}
