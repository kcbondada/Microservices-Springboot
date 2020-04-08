package com.financialmanagement.FinancialManagement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Commands {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commandId;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="action")
	private Action action;
	
	@Lob
	@NotNull
	private String comment;
	
	@ManyToOne
	private Accounts acc;
	
	public long getCommandId() {
		return commandId;
	}

	public void setCommandId(long commandId) {
		this.commandId = commandId;
	}

	public Accounts getAcc() {
		return acc;
	}

	public void setAcc(Accounts acc) {
		this.acc = acc;
	}

	public Commands() {
		super();
	}

	
	public Commands(long commandId, @NotNull Action action, @NotNull String comment, Accounts acc) {
		super();
		this.commandId = commandId;
		this.action = action;
		this.comment = comment;
		this.acc = acc;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}	
}
