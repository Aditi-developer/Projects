package com.example.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contact_us")
public class ContactUsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name should not be null")
	public String name;

	@Column(name = "mobile_number")
	@NotBlank(message = "mobile number should not be blank")
	@NotNull(message = "mobile number should not be null")
	@Size(min = 10, message = "mobile number should be 10 digits")
	public String mobileNumber;

	@Column(name = "email")
	@NotBlank(message = "email should not be blank")
	@NotNull(message = "email should not be null")
	public String email;
}
