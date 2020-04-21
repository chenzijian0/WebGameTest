package com.justicekn.webgame.Handler.Login;

import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import com.justicekn.webgame.DAO.Interface.Login.CheckAtLogin;
import com.justicekn.webgame.DAO.Interface.Login.UserGameAttributesGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginHandler {
    @Autowired
    CheckAtLogin checkAtLogin;
    @Autowired
    UserGameAttributesGet userGameAttributesGet;

    public String checked(String account, String pwd) {
        int result = checkAtLogin.checkAccount(account, pwd);
        if (result == 1) {
            return "ok";
        } else {
            return "no";
        }
    }

    public int findIdAtLogin(String account) {
        int result = checkAtLogin.findId(account);
        return result;
    }

    public String findNameAtLogin(String account) {
        return checkAtLogin.findName(account);
    }

    public UserGameAttributes GetUserGameAttributes(int id) {
        return userGameAttributesGet.getUserGameAttributes(id);
    }

    public int findKfbAtLogin(int id){
        return checkAtLogin.findKfb(id);
    }
}
