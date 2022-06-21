package com.app.op.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

/**
 * Used to generate order sequence id
 *
 */
@Component
public class OrderSequenceGenerator {

	private AtomicLong counter;

	public OrderSequenceGenerator() {
		super();
		counter = new AtomicLong(0l);
	}

	public Long getId() {
		return counter.incrementAndGet();
	}
}
