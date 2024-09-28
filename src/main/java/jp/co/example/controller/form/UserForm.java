package jp.co.example.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserForm {
    @NotBlank(message = "{jakarta.validation.constraints.NotBlank.message}")//文字化けするからこれが必要
    private String userName;

    @NotNull(message = "{jakarta.validation.constraints.NotNull.message}")
    private Integer userPrice;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(Integer userPrice) {
        this.userPrice = userPrice;
    }
}
