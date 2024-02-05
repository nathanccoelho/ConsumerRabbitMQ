package com.mewtwo.consumertest.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "tb_transactions")
public class Transaction {
    
    @Id
    private UUID idTransaction;

    @ManyToOne
    @JsonIgnoreProperties("transaction")
    private Person person;

    @NotNull
    private String transactionDate;

    @NotNull
    private int amount;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("transaction")
    private List<Installment> installment;
	public UUID getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(UUID idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<Installment> getInstallment() {
		return installment;
	}

	public void setInstallment(List<Installment> installment) {
		this.installment = installment;
	}
	

	
}