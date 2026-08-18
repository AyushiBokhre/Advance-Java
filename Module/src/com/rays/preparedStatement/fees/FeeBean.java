package com.rays.preparedStatement.fees;

import java.util.Date;

public class FeeBean {
	private int feeId;
	private int studentId;
	private int amount;
	private Date paymentDate;
	private String paymentStatus;

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int i) {
		this.studentId = i;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	

}
