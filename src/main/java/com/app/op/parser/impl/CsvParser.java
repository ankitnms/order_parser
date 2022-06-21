package com.app.op.parser.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.op.constant.OrderParserConstant;
import com.app.op.model.Order;
import com.app.op.parser.Parser;
import com.app.op.service.OrderSequenceGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * CsvParser used to parse CSV files
 *
 */
@Component
public class CsvParser extends Parser {

	private static ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private OrderSequenceGenerator seqGen;

	@Override
	protected void readRow(String fileName, String sCurrentLine, int lineNo) {
		CsvToBean<Order> bean = new CsvToBeanBuilder<Order>(
				new InputStreamReader(new ByteArrayInputStream(sCurrentLine.getBytes()))).withType(Order.class)
						.withThrowExceptions(false).withOrderedResults(true).build();
		bean.stream().forEach((order) -> {
			order.setFileName(fileName);
			order.setId(seqGen.getId());
			order.setResult(OrderParserConstant.RESULT_SUCCESS);
			order.setLine(lineNo);
			try {
				System.out.println(objectMapper.writeValueAsString(order));
			} catch (JsonProcessingException e) {
				System.err.println(e);
				e.printStackTrace();
			}
		});
		bean.getCapturedExceptions().stream().forEach((exception) -> {
			Order order = new Order();
			order.setFileName(fileName);
			order.setId(seqGen.getId());
			order.setLine(lineNo);
			order.setResult(exception.getMessage());
			try {
				System.err.println(objectMapper.writeValueAsString(order));
			} catch (JsonProcessingException e) {
				System.err.println(e);
				e.printStackTrace();
			}
		});

	}

}