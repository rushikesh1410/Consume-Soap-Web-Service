package com.consumeSoap1.output;



public class Response {

	public int intA;
	public int intB;
	public int result;

	public int getResult() {
		return result;
	}

	public int setResult(int result) {
		return this.result = result;
	}

	public Response(int intA, int intB, int result) {
		super();
		this.intA = intA;
		this.intB = intB;
		this.result = result;
	}

	public int getIntA() {
		return intA;
	}

	public void setIntA(int intA) {
		this.intA = intA;
	}

	public int getIntB() {
		return intB;
	}

	public void setIntB(int intB) {
		this.intB = intB;
	}

	public Response() {
		super();
	}

}
