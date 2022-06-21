package com.app.op.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.app.op.exception.FileNotFoundException;

/**
 * Parser class provide methods to read and parse input files.
 *
 */
public abstract class Parser {

	public void parse(String filePath) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
			int lineNo = 0;
			String sCurrentLine = null;
			final String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
			while ((sCurrentLine = br.readLine()) != null) {
				lineNo++;
				readRow(fileName, sCurrentLine, lineNo);
			}
		} catch (IOException e) {
			System.err.println("File path not found " + filePath);
			throw new FileNotFoundException("File path not found", e);
		}
	}

	protected abstract void readRow(String fileName, String sCurrentLine, int lineNo);
}
