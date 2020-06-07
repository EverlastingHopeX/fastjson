package com.alibaba.fastjson.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;

class JSONScannerTest2 {

	@Test
	void testInfo() {
		StringBuilder sb=new StringBuilder("\n");
		for(int i=0;i<65540;i++) {
			sb.append(1);
		}
		String text=sb.toString();
		JSONScanner scanner=new JSONScanner(text);
		scanner.bp=1000;
		String result=scanner.info();
		System.out.println(result);
	}

	@Test
	void testBytesValue() {
		JSONScanner scanner=new JSONScanner("123");
		scanner.token=JSONToken.HEX;
		scanner.sp=3;
		assertThrows(JSONException.class,()->scanner.bytesValue());
	}

	@Test
	void testScanFieldSymbol() {
//		fail("Not yet implemented");
		JSONScanner scanner=new JSONScanner("  \"strPro\":str\\n");
		char[] fieldName=new String("\"strPro\":").toCharArray();
		assertEquals(0,scanner.scanFieldSymbol(fieldName));
	}

	@Test
	void testScanFieldDate() {
//		fail("Not yet implemented");
		
		JSONScanner scanner=new JSONScanner("\"datePro\":\"2020-05-15\"\n");
		char[] fieldName=new String("\"datePro\":").toCharArray();
		scanner.scanFieldDate(fieldName);
	}

	@Test
	void testScanDate() {
//		fail("Not yet implemented");
		JSONScanner scanner=new JSONScanner("\"2020-05-15\",\"2020-05-15\"");
		Date d=scanner.scanDate(',');
		System.out.println(d);
	}

	@Test
	void testSubString() {
//		fail("Not yet implemented");
		
		JSONScanner scanner=new JSONScanner("123");
		System.setProperty("java.vm.name", "dalvik");
		scanner.subString(0, 2);
	}

	@Test
	void testSub_chars() {
//		fail("Not yet implemented");
		
		JSONScanner scanner=new JSONScanner("123");
		System.setProperty("java.vm.name", "dalvik");
		scanner.sub_chars(0, 2);
	}

	@Test
	void testDecimalValue() {
//		fail("Not yet implemented");
		StringBuilder sb=new StringBuilder("");
		for(int i=0;i<512;i++) {
			sb.append(1);
		}
		String text=sb.toString();
		JSONScanner scanner=new JSONScanner(text);
//		scanner.np=0;
		scanner.sp=512;
		BigDecimal bd=scanner.decimalValue();
//		System.out.println(bd);
	}

	@Test
	void testCheckTime() {
		char h0='0',h1='0';
		char m0='0',m1='0';
		char s0='0', s1='0';
		JSONScanner scanner=new JSONScanner("123");
		assertEquals(true, scanner.checkTimeTest(h0, h1, m0, m1, s0, s1));
	}
}
