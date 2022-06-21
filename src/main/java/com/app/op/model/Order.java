package com.app.op.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByPosition;

/**
 * order response model
 *
 */
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	@CsvBindByPosition(position = 0, required = true)
	private Long orderId;

	@CsvBindByPosition(position = 1, required = true)
	private Double amount;

	@CsvBindByPosition(position = 2, required = true)
	private String currency;

	@CsvBindByPosition(position = 3, required = true)
	private String comment;
	private String fileName;
	private long line;
	private String result;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getLine() {
		return line;
	}

	public void setLine(long line) {
		this.line = line;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", amount=" + amount + ", currency=" + currency
				+ ", comment=" + comment + ", fileName=" + fileName + ", line=" + line + ", result=" + result + "]";
	}

	public Order(@JsonProperty(required = false, value = "id") Long id,
			@JsonProperty(required = true, value = "orderId") Long orderId,
			@JsonProperty(required = true, value = "amount") Double amount,
			@JsonProperty(required = true, value = "currency") String currency,
			@JsonProperty(required = true, value = "comment") String comment,
			@JsonProperty(required = false, value = "fileName") String fileName,
			@JsonProperty(required = false, value = "line") long line,
			@JsonProperty(required = false, value = "result") String result) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.amount = amount;
		this.currency = currency;
		this.comment = comment;
		this.fileName = fileName;
		this.line = line;
		this.result = result;
	}

	public Order() {
		super();
	}

}
