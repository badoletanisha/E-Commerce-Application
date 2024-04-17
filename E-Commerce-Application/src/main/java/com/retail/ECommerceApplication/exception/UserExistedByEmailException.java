package com.retail.ECommerceApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserExistedByEmailException extends RuntimeException {
private String message;

}
