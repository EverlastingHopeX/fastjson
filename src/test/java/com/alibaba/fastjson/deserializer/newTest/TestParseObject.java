package com.alibaba.fastjson.deserializer.newTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class TestParseObject {

	@Test
	void test1() {
		String text="{\"str\":\"a string\"}";
		JSONObject actual=JSON.parseObject(text);
		JSONObject expected=new JSONObject();
		expected.put("str", "a string");
		
		assertEquals(expected, actual);
	}
//	
	@Test
	void test2() {
		String text="{'str':'a string'}";
		Feature f=Feature.AllowSingleQuotes;
		JSONObject actual=JSON.parseObject(text,f);
		JSONObject expected=new JSONObject();
		expected.put("str", "a string");
		
		assertEquals(expected, actual);
	}
//	
	@Test
	void test3() {
		String text="[1,2,3]";
		Feature f=Feature.AllowSingleQuotes;
		List<Integer> li=JSON.parseObject(text,new TypeReference<List<Integer>>() {},f);
//		System.out.println(li);
		List<Integer> expected=new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		assertEquals(li,expected);
	}
	
	@Test
	void test4() {
		String text="{'strPro':'str','intPro':1}";
		Feature f=Feature.AllowSingleQuotes;
		aSimClass actual=JSON.parseObject(text,aSimClass.class,f);
		assertEquals("str",actual.getStrPro());
		assertEquals(1,actual.getIntPro());
	}
	
	@Test
	void test5() {
		String text="{'strPro':'str','intPro':1}";
		Feature f=Feature.AllowSingleQuotes;
		JSON.parseObject(text,aSimClass.class,ParserConfig.global,f);
	}
	
	@Test
	void test6() {
//		fail("Not yet implemented");
		String text="{'strPro':'str','intPro':1}";
		JSON.parseObject(text,aSimClass.class);
	}
	
	@Test
	void test7() {
		fail("Not yet implemented");
		String text="{'strPro':'str','intPro':1}";
		ExtraProcessor p = new ExtraProcessor() {
            public void processExtra(Object object, String key, Object value) {
                System.out.println("setter not found, class " + object.getClass().getName() + ", property " + key);
            }
        };
        
		Feature f=Feature.AllowSingleQuotes;
		JSON.parseObject(text,aSimClass.class,p,f);
	}
	
	@Test
	void test8() {
		fail("Not yet implemented");
		String text="{'strPro':'str','intPro':1}";
		Feature f=Feature.AllowSingleQuotes;
		JSON.parseObject(text,aSimClass.class,ParserConfig.global,f);	
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
