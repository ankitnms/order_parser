package com.app.op.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.app.op.constant.FileTypes;
import com.app.op.parser.impl.CsvParser;
import com.app.op.parser.impl.JsonParser;

@Component
public class ParserFactory {
	@Autowired
	private ApplicationContext сontext;

	/**
	 * Parser factory method to return required parser implementation.
	 * 
	 * @param fileName
	 * @return Parser
	 */
	public Parser getParser(String filePath) {
		String fileExtn = filePath.substring(filePath.lastIndexOf(".") + 1);
		if (FileTypes.JSON.name().equalsIgnoreCase(fileExtn)) {
			return сontext.getBean(JsonParser.class);
		} else if (FileTypes.CSV.name().equalsIgnoreCase(fileExtn)) {
			return сontext.getBean(CsvParser.class);
		} else {
			System.err.println("File parser currently not supported for file:" + filePath);
			throw new IllegalArgumentException("File parser currently not supported for file:" + filePath);
		}
	}
}