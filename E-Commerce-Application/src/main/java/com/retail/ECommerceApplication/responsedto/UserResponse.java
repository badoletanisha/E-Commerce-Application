package com.retail.ECommerceApplication.responsedto;


import com.retail.ECommerceApplication.enums.userRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
	private int userId;
	private String displayName;
	private String email;
	private String username;
	private boolean isEmailVerified;
	private boolean isDelete;
	private userRole userRole;
}

