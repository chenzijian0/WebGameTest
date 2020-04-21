package com.justicekn.webgame.Bean.Registe;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountRegisterBean {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String pwd;
    @NotNull
    @NotEmpty
    private String account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
