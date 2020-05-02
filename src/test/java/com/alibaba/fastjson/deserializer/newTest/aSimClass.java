package com.alibaba.fastjson.deserializer.newTest;

class aSimClass {
	private String strPro="";
	private int intPro=-1;
	
	public aSimClass() {
		strPro="";
		intPro=-1;
	}
	
	public aSimClass(String str, int i) {
		strPro=str;
		intPro=i;
	}
	
	public String getStrPro() {
		return strPro;
	}
	public void setStrPro(String strPro) {
		this.strPro = strPro;
	}
	public int getIntPro() {
		return intPro;
	}
	public void setIntPro(int intPro) {
		this.intPro = intPro;
	}
}
