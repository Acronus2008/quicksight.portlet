package com.tl.quicksight.portlet.dashboard;

public class DashboardData {
	private String dashboardType;
	private String dashboardId;
	
	public DashboardData(String dashboardType, String dashboardId) {
		super();
		setDashboardType(dashboardType);
		setDashboardId(dashboardId);
	}	
	
	public DashboardData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getDashboardId() {
		return dashboardId;
	}

	public String getDashboardType() {
		return dashboardType;
	}

	private void setDashboardId(String dashboardId) {
		this.dashboardId = dashboardId;
	}
	
	private void setDashboardType(String dashboardType) {
		this.dashboardType = dashboardType;
	}
	
	

}
