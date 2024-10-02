package jp.co.hoge.web.controller.form;

import jakarta.validation.constraints.NotBlank;

public class UserForm {
	
	 @NotBlank
	private String loginId;
	 @NotBlank
	 private String password;
	

	
	 
	 private Integer roleId;
	
	 private String select;
	 
	 private String insert;
	 
	 private String name1;
	 
	 private String tel1;
	 
	
	 
	 
	
	 public String getUserName() {
		return name1;
	}

	public void setUserName(String name1) {
		this.name1 = name1;
	}

	public String getTelephone() {
		return tel1;
	}

	public void setTelephone(String tel1) {
		this.tel1 = tel1;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	 
	 

	public String getName() {
		return name1;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public void setName(String name1) {
		this.name1 = name1;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public String getLoginId() {
		return loginId;

	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}