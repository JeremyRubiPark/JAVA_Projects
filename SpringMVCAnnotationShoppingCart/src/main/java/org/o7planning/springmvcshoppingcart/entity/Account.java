package org.o7planning.springmvcshoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account implements Serializable{
	private String userName;
	private String passWord;
	private boolean active;
	private String userRole;
	
	
	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	
	@Id
	@Column(name="User_name", length=20, nullable=false)
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="Password", length=20, nullable=false)
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name="User_Role", length=20, nullable=false)
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@Column(name="Active", length=1, nullable=false)
	public void isActive() {
		
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "[" + userName + "," + passWord + "," + userRole + "]";
	}
	
	
}
