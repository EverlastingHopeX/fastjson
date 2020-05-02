package com.alibaba.fastjson.deserializer.newTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;


public class TestVariousJSON {

	@Test
	public void testEmpty() {
		String json="{:}";
		assertThrows(JSONException.class,()->JSON.parseObject(json,aSimClass.class),"wrong format not detected");
//		aSimClass expected=new aSimClass();
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
}
