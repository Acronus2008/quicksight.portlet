package com.tl.quicksight.portlet;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.amazonaws.services.quicksight.model.GetDashboardEmbedUrlResult;
import com.tl.quicksight.portlet.aws.quicksight.QuickSightHandler;

@ManagedBean
@ViewScoped
public class MainBean {
	
	private QuickSightHandler quickSightHandler;
	
	private final String dashboardId = "3d566df0-d3a8-47b5-a98e-3a9401117da1";
	private final String awsAccountId = "472925736224";
	private final String accessKey = "AKIAW4HESBUQPQQEWORE";
	private final String secretKey = "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";
    
    public MainBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmbbededUrl() {
		try {
			quickSightHandler = new QuickSightHandler();
			GetDashboardEmbedUrlResult dashboardEmbedUrlResult = quickSightHandler.getQuickSightDashboardUrl(dashboardId, awsAccountId, accessKey, secretKey);
			return dashboardEmbedUrlResult.getEmbedUrl();
		} catch (Exception e) {
			System.out.println(String.format("Error %s : Al parecer estas intentando obtener el dashboard cuando estas en plan QuickSight Standard -> %s", "MainBean -> getEmbbededUrl()", e.getMessage()));
			return null;
		}
	}    
}
