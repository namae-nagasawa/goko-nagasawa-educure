package jp.co.hoge.web.controller.form;

import jakarta.validation.constraints.NotBlank;

public class UserForm {
	
	 @NotBlank
	private String loginId;
	 @NotBlank
	 private String password;
	@NotBlank
	 private String name;
	@NotBlank
	 private String telephone;
	
	private Integer roleId;
	
	private String select;
	
	private String insert;
	
	private String roleName;
	 
	private String rePass;


	public String getRePass() {
		return rePass;
	}

	public void setRePass(String rePass) {
		this.rePass = rePass;
	}
	
	
	 public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserName() {
		return name;
	}

	public void setUserName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	 
	 

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
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