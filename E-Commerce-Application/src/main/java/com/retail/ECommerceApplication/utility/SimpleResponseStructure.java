package com.retail.ECommerceApplication.utility;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class SimpleResponseStructure {

	private int satuscode;
	private String message;
	
	public SimpleResponseStructure setSatuscode(int satuscode) {
		this.satuscode = satuscode;
		return this;
	}
	public SimpleResponseStructure setMessage(String message) {
		this.message = message;
		return this;
	}
	
	
}
