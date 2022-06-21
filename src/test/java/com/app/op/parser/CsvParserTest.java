package com.app.op.parser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.app.op.exception.FileNotFoundException;
import com.app.op.parser.impl.CsvParser;
import com.app.op.service.OrderSequenceGenerator;

@RunWith(MockitoJUnitRunner.class)
public class CsvParserTest {

	@Mock
	private OrderSequenceGenerator generator;

	@InjectMocks
	private CsvParser parser;

	@Test(expected = FileNotFoundException.class)
	public void testForInvalidFilePath() {
		parser.parse("src/test/resources/ordersXXX.csv");
	}

	@Test
	public void testForValidFile() {
		parser.parse("src/test/resources/orders1.csv"); // Modify orders1.csv
														// file for other
														// scenarios
	}
}
