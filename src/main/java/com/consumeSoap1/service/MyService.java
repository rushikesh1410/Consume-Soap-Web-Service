package com.consumeSoap1.service;

import com.consumeSoap1.output.Response;


public interface MyService {
	
	public Response getAddResultService(Response requestbody);

	public Response getSubtractResultService(Response requestbody);

	public Response getMultiplyResultService(Response requestbody);

	public Response getDivideResultService(Response requestbody);
}
