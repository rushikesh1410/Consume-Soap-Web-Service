package com.consumeSoap1.service.impl;

import org.springframework.stereotype.Service;

import com.consumeSoap1.service.MyService;
import io.codejournal.maven.wsdl2java.Calculator;
import com.consumeSoap1.output.Response;


@Service
public class MyServiceImpl implements MyService {

	Response Response = new Response();
	
    Calculator calculator = new Calculator();
	
	public com.consumeSoap1.output.Response getAddResultService(com.consumeSoap1.output.Response requestbody) {
		int res =calculator.getCalculatorSoap().add(requestbody.intA, requestbody.intB);
	   Response Response = new Response(requestbody.intA,requestbody.intB,requestbody.setResult(res));
	    return Response;
	}

	public Response getSubtractResultService(com.consumeSoap1.output.Response requestbody) {
		int res =calculator.getCalculatorSoap().subtract(requestbody.intA, requestbody.intB);
	   Response Response = new Response(requestbody.intA,requestbody.intB,requestbody.setResult(res));
	    return Response;
	}

	@Override
	public Response getMultiplyResultService(com.consumeSoap1.output.Response requestbody) {
	    int res =calculator.getCalculatorSoap().multiply(requestbody.intA, requestbody.intB);
	   Response Response = new Response(requestbody.intA,requestbody.intB,requestbody.setResult(res));
	    return Response;
	}

	@Override
	public Response getDivideResultService(com.consumeSoap1.output.Response requestbody) {
		int res =calculator.getCalculatorSoap().divide(requestbody.intA, requestbody.intB);
	   Response Response = new Response(requestbody.intA,requestbody.intB,requestbody.setResult(res));
	    return Response;
	}
}
