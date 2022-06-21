package com.app.op.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.op.parser.ParserFactory;

@Service
public class OrderParserService {
	@Autowired
	private ParserFactory parserFactory;

	public void processFiles(String[] filePaths) {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newFixedThreadPool(filePaths.length);
			for (String filePath : filePaths) {
				executorService.submit(() -> parserFactory.getParser(filePath).parse(filePath));
			}
		} finally {
			if (executorService != null) {
				executorService.shutdown();
			}

		}
	}

}
