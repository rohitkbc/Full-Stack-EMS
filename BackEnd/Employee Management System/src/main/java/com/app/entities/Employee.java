package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee extends BaseEntity{
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String location;
	@Column(length = 20, name="dept_name")
	@JsonProperty(value = "department")
	private String dept;
//	public Employee() {
//		// TODO Auto-generated constructor stub
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getLocation() {
//		return location;
//	}
//	public void setLocation(String location) {
//		this.location = location;
//	}
//	public String getDept() {
//		return dept;
//	}
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//	@Override
//	public String toString() {
//		return "Employee [name=" + name + ", location=" + location + ", dept=" + dept + "]";
//	}
	
}
