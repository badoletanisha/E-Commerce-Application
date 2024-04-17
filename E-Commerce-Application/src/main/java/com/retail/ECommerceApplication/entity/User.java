package com.retail.ECommerceApplication.entity;

import com.retail.ECommerceApplication.enums.userRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "username")
	@NotNull
	private String username;
	private String displayName;
	
	@NotBlank(message = "Invalid Email")
	@NotNull(message = "Invalid Email")
	@Column(unique = true, name = "email")
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",message = "invalid email format")
	@Schema(required  = true)
	private String email;
	
	@NotBlank(message = "Invalid Password")
	@NotNull(message = "Invalid Password")
	@Size(min = 8,max = 20,message = "password must be between 8 and 20 charecter")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$",message = "password must be contain at least one uppercase letter,one lowercase letter,one digit,one special charecter")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private userRole userRole;
	private boolean isEmailVerified;
	private boolean isDelete;
}


