package com.alibaba.fastjson.deserializer.newTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


public class TestVariousJSON {

	@Test
	public void testEmpty() {
		String json="{:}";
		assertThrows(JSONException.class,()->JSON.parseObject(json,aSimClass.class),"wrong format not detected");
	}
	
	@Test
	public void testSingleQuote() {
		String json1="{'strPro':'str', 'intPro':1}";
		String json2="{\"strPro\":\"str\", \"intPro\":1}";
		JSONObject obj1=JSON.parseObject(json1);
		JSONObject obj2=JSON.parseObject(json2);
		String str1=JSON.toJSONString(obj1);
		String str2=JSON.toJSONString(obj2);
		System.out.println(str1);
		
		assertEquals(str1,str2);
	}
	
	@Test
	public void testSuc() {
		String json="{\"strPro\": \"str\", \"intPro\": 1}";
		JSON.parseObject(json,aSimClass.class);
	}
	
	@Test
	public void testMissingPro() {
		String json="{\"strPro\": \"str\"}";
		aSimClass actual=JSON.parseObject(json,aSimClass.class);
		assertEquals(-1, actual.getIntPro());
	}
	
	@Test
	public void testOverflow() {
		String over=((long)Integer.MAX_VALUE+1)+"";
		String json="{\"strPro\": str , \"intPro\": "+over+"}";
//		System.out.println(str);
		assertThrows(JSONException.class,()->JSON.parseObject(json,aSimClass.class),"overflow not detected");
	}
	
	public class aSimClass{
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
}
