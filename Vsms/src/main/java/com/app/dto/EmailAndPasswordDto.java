package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class EmailAndPasswordDto {
	@NotBlank(message = "email field cannot be blank!")
	@Email(message = "provide valid email id")
	private String email;
	
	@NotBlank(message = "provide valid password")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})", message = "Invalid password")
	private String password;

}
