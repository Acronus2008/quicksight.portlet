package com.tl.quicksight.portlet.dashboard;

public enum DashboardType {
	
	DASHBOARD_1("Retail Business Insights 1. TAP Units"),
	DASHBOARD_2("Retail Business Insights 2. TAP Units Roamers Type"),
	DASHBOARD_3("Retail Business Insights 7. Customer Map A");

	private final String value;

	private DashboardType(String value) {
		this.value = value;
	}

	public Object value() {
		return value;
	}	
}
