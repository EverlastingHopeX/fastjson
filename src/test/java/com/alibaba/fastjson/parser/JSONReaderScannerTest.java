package com.alibaba.fastjson.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSONException;
import com.alibaba.json.bvt.parser.JSONReaderScannerTest__entity_boolean.VO;

class JSONReaderScannerTest {

	@Test
	void testNumberString() {
//		fail("Not yet implemented");
		Reader reader = new StringReader("{'strPro':'str','intPro':1}");
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
        scanner.np=-1;
        scanner.numberString();
	}

	@Test
	void testCharAt() {
//		fail("Not yet implemented");
		
        Reader reader = new StringReader("{'intPro':1}");
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertThrows(JSONException.class,()->scanner.charAt(20));
	}
	
	@Test
	void testCharAt2() {
//		fail("Not yet implemented");
		
        Reader reader = new StringReader("{'intPro':1}");
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
        scanner.next();
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertThrows(JSONException.class,()->scanner.charAt(20));
	}
	
	@Test
	void testCharAt3() {
		fail("Not yet implemented");
		
//        Reader reader = new StringReader("{}");
//        JSONReaderScanner scanner = new JSONReaderScanner(reader);
//        scanner.next();// bp 1
//        scanner.charAt(13);
//        assertThrows(JSONException.class,()->scanner.charAt(20));
	}

	@Test
	void testBytesValue() {
//		fail("Not yet implemented");
		Reader reader = new StringReader("{'intPro':1}");
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
        scanner.token=JSONToken.HEX;
        assertThrows(JSONException.class,()->scanner.bytesValue());
	}

	@Test
	void testStringVal() {
//		fail("Not yet implemented");
		Reader reader = new StringReader("{'intPro':1}");
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
        scanner.np=-2;
        assertThrows(IllegalStateException.class,()->scanner.stringVal());
	}
	
	@Test
	void testStringVal2() {
//		fail("Not yet implemented");
		Reader reader = new StringReader("{'intPro':1}");
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
        scanner.np=20000;
        assertThrows(IllegalStateException.class,()->scanner.stringVal());
	}

	@Test
	void testSubString() {
//		fail("Not yet implemented");
		
		Reader reader = new StringReader("{'intPro':1}");
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
//        scanner.subString(0, -1);
        assertThrows(StringIndexOutOfBoundsException.class,()->scanner.subString(0, -1));
	}

	@Test
	void testSub_chars() {
//		fail("Not yet implemented");
		String str="{'intPro':1}";
		Reader reader = new StringReader(str);
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
//        scanner.sub_chars(0, -1);
        assertThrows(StringIndexOutOfBoundsException.class,()->scanner.sub_chars(0, -1));
	}
	
	@Test
	void testSub_chars2() {
//		fail("Not yet implemented");
		String str="{'intPro':1}";
		Reader reader = new StringReader(str);
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
        scanner.sub_chars(0, 12);
	}

	@Test
	void testIsBlankInput() {
//		fail("Not yet implemented");
        JSONReaderScanner scanner = new JSONReaderScanner("{'strPro':'str','intPro':1}");
        assertEquals(scanner.isBlankInput(),false);
	}

	@Test
	void testDecimalValue() {
//		fail("Not yet implemented");
		Reader reader = new StringReader("1L");
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
        scanner.np=-1;
        scanner.sp=2;
        scanner.decimalValue();
	}
	
	@Test
	void testNext() {
		Reader reader = new StringReader("{'strPro':'str','intPro':1}");
        JSONReaderScanner scanner = new JSONReaderScanner(reader);
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        scanner.bp=30;
        assertThrows(JSONException.class,()->scanner.next());
	}
}
