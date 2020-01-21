package com.tl.quicksight.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.amazonaws.services.quicksight.model.GetDashboardEmbedUrlResult;
import com.tl.quicksight.portlet.aws.quicksight.QuickSightHandler;
import com.tl.quicksight.portlet.dashboard.DashboardData;
import com.tl.quicksight.portlet.dashboard.DashboardType;

@ManagedBean
@ViewScoped
public class MainBean {
	
	private QuickSightHandler quickSightHandler;
	
	private final String dashboardId = "3d566df0-d3a8-47b5-a98e-3a9401117da1";
	private final String awsAccountId = "472925736224";
	private final String accessKey = "AKIAW4HESBUQPQQEWORE";
	private final String secretKey = "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";
	
	
	private List<DashboardData> dashboards;
	private String dashBoardSelected;
	private String embbededDashboardData;
    
    public MainBean() {
    	dashboards = new ArrayList<>();
    	dashboards.add(new DashboardData(DashboardType.DASHBOARD_1.value().toString(), "3d566df0-d3a8-47b5-a98e-3a9401117da1"));
    	dashboards.add(new DashboardData(DashboardType.DASHBOARD_2.value().toString(), "3d566df0-d3a8-47b5-a98e-111111111111"));
    	dashboards.add(new DashboardData(DashboardType.DASHBOARD_3.value().toString(), "3d566df0-d3a8-47b5-a98e-222222222222"));
	}
    
    public void loadDashboardData() {
    	try {
			quickSightHandler = new QuickSightHandler();
			GetDashboardEmbedUrlResult dashboardEmbedUrlResult = quickSightHandler.getQuickSightDashboardUrl(dashBoardSelected, awsAccountId, accessKey, secretKey);
			embbededDashboardData = dashboardEmbedUrlResult.getEmbedUrl();
		} catch (Exception e) {
			System.out.println(String.format("Error %s : Al parecer estas intentando obtener el dashboard cuando estas en plan QuickSight Standard -> %s", "MainBean -> getEmbbededUrl()", e.getMessage()));
		}
    }

	public List<DashboardData> getDashboards() {
		return dashboards;
	}

	public void setDashboards(List<DashboardData> dashboards) {
		this.dashboards = dashboards;
	}

	public String getDashBoardSelected() {
		return dashBoardSelected;
	}

	public void setDashBoardSelected(String dashBoardSelected) {
		this.dashBoardSelected = dashBoardSelected;
	}

	public String getEmbbededDashboardData() {
		return embbededDashboardData;
	}

	public void setEmbbededDashboardData(String embbededDashboardData) {
		this.embbededDashboardData = embbededDashboardData;
	}    
}
