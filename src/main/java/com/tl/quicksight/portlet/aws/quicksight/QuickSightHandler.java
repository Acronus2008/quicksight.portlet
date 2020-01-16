package com.tl.quicksight.portlet.aws.quicksight;

import com.amazonaws.services.quicksight.model.GetDashboardEmbedUrlRequest;
import com.amazonaws.services.quicksight.model.GetDashboardEmbedUrlResult;
import com.amazonaws.services.quicksight.model.IdentityType;
import com.tl.quicksight.portlet.aws.AwsUtil;

public class QuickSightHandler {

	public GetDashboardEmbedUrlResult getQuickSightDashboardUrl(String dashboardId, String awsAccountId, String accessKey, String secretKey) {
		
		try {
			return AwsUtil.getClient(accessKey, secretKey)
					.getDashboardEmbedUrl(new
							GetDashboardEmbedUrlRequest().withDashboardId(dashboardId)
							.withAwsAccountId(awsAccountId).withIdentityType(IdentityType.IAM).
							withResetDisabled(true)
							.withSessionLifetimeInMinutes(100l).withUndoRedoDisabled(false));	
		} catch (Exception e) {
			System.out.println(String.format("Error en%s : Al parecer a ocurrido un error creando el cliente de QuickSitght -> %s", "QuickSightHandler -> getQuickSightDashboardUrl(...)", e.getMessage()));
			return null;
		}
	}
}
