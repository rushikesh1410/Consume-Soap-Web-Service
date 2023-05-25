package com.consumeSoap1.output;

public class output {
	
	public Object intA;
	public Object intB;
	public Object result;
	
	public Object getIntA() {
		return intA;
	}
	public void setIntA(Object intA) {
		this.intA = intA;
	}
	public Object getIntB() {
		return intB;
	}
	public void setIntB(Object intB) {
		this.intB = intB;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	public output() {
		super();
	}
	
	public output(Object intA, Object intB, Object result) {
		super();
		this.intA = intA;
		this.intB = intB;
		this.result = result;
	}

}
