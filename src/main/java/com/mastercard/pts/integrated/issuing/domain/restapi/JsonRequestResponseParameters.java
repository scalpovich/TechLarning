package com.mastercard.pts.integrated.issuing.domain.restapi;

import org.springframework.stereotype.Component;

import com.jayway.restassured.response.Response;

@Component
public class JsonRequestResponseParameters {
	private Response response;
	private String updatedReq;

	public Response getResponse() {
		return response;
	}

	public String getUpdatedReq() {
		return updatedReq;
	}

	public void setUpdatedReq(String updatedReq) {
		this.updatedReq = updatedReq;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	
}
