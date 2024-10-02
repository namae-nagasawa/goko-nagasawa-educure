package jp.co.hoge.web.entity;

public class User {

	private Integer user_id;
	private String login_id;
	private String user_name;
	private String telephone;
	private String password;

	private Integer role_id;
	private String role_name;

	public Integer getUserId() {
		return user_id;
	}

	public void setUserId(Integer user_id) {
		this.user_id = user_id;
	}

	public String getLoginId() {
		return login_id;
	}

	public void setLoginId(String login_id) {
		this.login_id = login_id;
	}

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return role_id;
	}

	public void setRoleId(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRoleName() {
		return role_name;
	}

	public void setRoleName(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", login_id=" + login_id + ", user_name=" + user_name + ", telephone="
				+ telephone + ", password=" + password + ", role_id=" + role_id + ", role_name=" + role_name + "]";
	}


}
