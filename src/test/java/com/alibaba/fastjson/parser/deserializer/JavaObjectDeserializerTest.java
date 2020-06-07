package com.alibaba.fastjson.parser.deserializer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;

import static org.mockito.Mockito.*;
import java.lang.reflect.Type;

class JavaObjectDeserializerTest {

	private JavaObjectDeserializer JODes;
	private DefaultJSONParser parser;
	
	@BeforeEach
	public void setup() {
		JODes=new JavaObjectDeserializer();
		parser=mock(DefaultJSONParser.class);
	}
	
	@Test
	public void testDeserialze() {
		aSimClass obj=mock(aSimClass.class);
		obj=new aSimClass("1",1);
		when(parser.parseObject(any(Type.class))).thenReturn(obj);
		aSimClass actual=JODes.deserialze(parser, aSimClass.class, "aSimClass");
		System.out.println(actual);
		verify(parser,times(1)).parseObject(any(Type.class));
	}
	
	public static class aSimClass{
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
