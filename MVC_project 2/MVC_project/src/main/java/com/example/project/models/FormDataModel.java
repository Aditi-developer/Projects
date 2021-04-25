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
@Table(name = "school")
public class FormDataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "schoolid")
	@NotBlank(message = "schoolID should not be blank")
	@NotNull(message = "schoolID should not be null")
	@Size(min = 8, message = "schoolID should be minimum 8 characters")
	public String schoolID;

	@Column(name = "schoolname")
	@NotBlank(message = "schoolName should not be blank")
	@NotNull(message = "schoolName should not be null")
	@Size(min = 5, message = "schoolName should be minimum 5 characters")
	public String schoolName;

	@Column(name = "coursename")
	@NotBlank(message = "courseName should not be blank")
	@NotNull(message = "courseName should not be null")
	@Size(min = 5, message = "courseName should be minimum 5 characters")
	public String courseName;
	
}
