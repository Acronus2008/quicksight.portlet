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
	
	private final String awsAccountId = "957370209474";
	private final String accessKey = "AKIA55Z5WCTBNGZ5CV5X";
	private final String secretKey = "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";
	
	
	private List<DashboardData> dashboards;
	private String dashBoardSelected;
	private String embbededDashboardData;
    
    public MainBean() {
    	dashboards = new ArrayList<>();
    	dashboards.add(new DashboardData(DashboardType.DASHBOARD_1.value().toString(), "f1149dd9-68a3-4746-9f40-fa8bca60aa3b"));
    	dashboards.add(new DashboardData(DashboardType.DASHBOARD_2.value().toString(), "07a53ba4-bbfa-4bdf-b267-e6f32c834c96"));
    	dashboards.add(new DashboardData(DashboardType.DASHBOARD_3.value().toString(), "f0a33858-8dd5-416e-94fa-317ffa382e69"));
	}
    
    public void loadDashboardData() {
    	try {
			quickSightHandler = new QuickSightHandler();
			GetDashboardEmbedUrlResult dashboardEmbedUrlResult = quickSightHandler.getQuickSightDashboardUrl(dashBoardSelected, awsAccountId, accessKey, secretKey);
			embbededDashboardData = dashboardEmbedUrlResult.getEmbedUrl();
			System.out.println(embbededDashboardData);
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
