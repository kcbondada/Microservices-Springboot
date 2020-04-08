package com.financialmanagement.FinancialManagement.dto;

import com.financialmanagement.FinancialManagement.entity.Action;

public class CommandsDto {
	
	private Action action;
	
	private String comment;

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

	public CommandsDto(Action action, String comment) {
		super();
		this.action = action;
		this.comment = comment;
	}

	public CommandsDto() {
		super();
	}
	

}
