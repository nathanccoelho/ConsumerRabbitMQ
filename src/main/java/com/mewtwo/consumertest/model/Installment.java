package com.mewtwo.consumertest.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "tb_installments")
public class Installment {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	private Long installmentNumber;

	private BigDecimal installmentValue;
	
	@ManyToOne
	@JsonIgnoreProperties("installment")
	private Transaction transaction;

	public Installment(Long installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public Installment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(Long installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public BigDecimal getInstallmentValue() {
		return installmentValue;
	}

	public void setInstallmentValue(BigDecimal installmentValue) {
		this.installmentValue = installmentValue;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}