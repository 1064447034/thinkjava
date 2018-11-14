package com.ly.study.thinkjava.except;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception {
	private static Logger logger = Logger.getLogger("LoggingException");
	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

public class ExceptionTest {
	public static void main(String[] args) throws Exception {
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("caught: " + e);
		}
	}
}
