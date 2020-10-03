package Util;

import io.restassured.RestAssured;

public class ImplMethodData {
	
	public String baseURI;
	public String accessToken;
	public String methodPath;
	public String userId;
	public String getBaseURI() {
		return baseURI;
	}
	public void setBaseURI(String baseURI) {
		RestAssured.baseURI = baseURI;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getMethodPath() {
		return methodPath;
	}
	public void setMethodPath(String methodPath) {
		this.methodPath = methodPath;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
