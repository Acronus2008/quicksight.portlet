package com.tl.quicksight.portlet.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.quicksight.AmazonQuickSight;
import com.amazonaws.services.quicksight.AmazonQuickSightClientBuilder;

public class AwsUtil {
	
	public static AmazonQuickSight getClient(String accessKey, String secretKey) {
    	final AWSCredentialsProvider credentialsProvider = new AWSCredentialsProvider() {
	  	  @Override public void refresh() { }
	  	  
	  	  @Override public AWSCredentials getCredentials() {
	  		return new BasicAWSCredentials(accessKey, secretKey);
	  	  }
  	  	};
  	  	
  	  return AmazonQuickSightClientBuilder
  			  .standard()
  			  .withRegion(Regions.EU_CENTRAL_1.getName())
  			  .withCredentials(credentialsProvider)
  			  .build();
  	  }
}
