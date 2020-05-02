package com.alibaba.fastjson.deserializer.newTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import java.lang.reflect.Type;

class TestParseObject {

	@Test
	void test1() {
		String text="";
		JSON.parseObject(text);
	}
	
	@Test
	void test2() {
		String text="";
		Feature f;
		JSON.parseObject(text,f);
	}
	
	@Test
	void test3() {
		String text="";
		TypeReference<T> tr;
		Feature f;
		JSON.parseObject(text,tr,f);
	}
	
	@Test
	void test4() {
		String text="";
		Class<T> clazz;
		Feature f;
		JSON.parseObject(text,clazz,f);
	}
	
	@Test
	void test5() {
		String text="";
		Class<T> clazz;
		ParseProcess p;
		Feature f;
		JSON.parseObject(text,clazz,p,f);
	}
	
	@Test
	void test6() {
		String text="";
		Class<T> clazz;
		JSON.parseObject(text,clazz);
	}
	
	@Test
	void test7() {
		String text="";
		Type clazz;
		ParseProcess p;
		Feature f;
		JSON.parseObject(text,clazz,p,f);
	}
	
	@Test
	void test8() {
		String text="";
		Type clazz;
		ParserConfig config;
		Feature f;
		JSON.parseObject(text,clazz,config,f);
	}

}
