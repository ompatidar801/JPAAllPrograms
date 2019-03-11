package com.patidar.om.oneToOneMapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "student_gen", table = "sid_gen", pkColumnName = "gen_sname", valueColumnName = "gen_sval", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	@Column(name = "sid")
	private int studentId;

	@Column(name = "sname", length = 10)
	private String studentName;

	@Column(name = "grp", length = 10)
	private String grp;

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	@OneToOne
	@JoinColumn(name = "addressId")
	private Address addressId;

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
}
