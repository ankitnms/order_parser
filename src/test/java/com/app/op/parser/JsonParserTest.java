package com.app.op.parser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.app.op.exception.FileNotFoundException;
import com.app.op.parser.impl.JsonParser;
import com.app.op.service.OrderSequenceGenerator;

@RunWith(MockitoJUnitRunner.class)
public class JsonParserTest {

	@Mock
	private OrderSequenceGenerator generator;

	@InjectMocks
	private JsonParser parser;

	@Test(expected = FileNotFoundException.class)
	public void testForInvalidFilePath() {
		parser.parse("src/test/resources/test.json");
	}

	@Test
	public void testForValidFilePath() {
		parser.parse("src/test/resources/orders2.json");// Modify this file for other scenarios
	}
}
