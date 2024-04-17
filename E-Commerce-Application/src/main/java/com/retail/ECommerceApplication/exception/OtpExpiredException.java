package com.retail.ECommerceApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
@SuppressWarnings("serial")
@AllArgsConstructor
@Getter
public class OtpExpiredException extends RuntimeException {
private String message;

}
