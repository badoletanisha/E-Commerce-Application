package com.retail.ECommerceApplication.requestdto;

import com.retail.ECommerceApplication.enums.userRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	private String name;
	private String email;
	private String password;
	private userRole userRole;
	
}
