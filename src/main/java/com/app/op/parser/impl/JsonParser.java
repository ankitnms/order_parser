package com.app.op.parser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.op.constant.OrderParserConstant;
import com.app.op.model.Order;
import com.app.op.parser.Parser;
import com.app.op.service.OrderSequenceGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonParser used to parse JSON files
 *
 */
@Component
public class JsonParser extends Parser {
	private static ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private OrderSequenceGenerator seqGen;

	@Override
	protected void readRow(String fileName, String sCurrentLine, int lineNo) {
		try {
			Order order = objectMapper.readValue(sCurrentLine, Order.class);
			order.setId(seqGen.getId());
			order.setFileName(fileName);
			order.setLine(lineNo);
			order.setResult(OrderParserConstant.RESULT_SUCCESS);
			System.out.println(objectMapper.writeValueAsString(order));
		} catch (JsonProcessingException e) {
			Order order = new Order();
			order.setId(seqGen.getId());
			order.setLine(lineNo);
			order.setFileName(fileName);
			order.setResult(e.getMessage());
			try {
				System.err.println(objectMapper.writeValueAsString(order));
			} catch (JsonProcessingException e1) {
				System.err.println(e1);
				e1.printStackTrace();
			}
		}
	}
}
