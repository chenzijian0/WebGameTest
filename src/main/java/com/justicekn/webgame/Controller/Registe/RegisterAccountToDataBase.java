package com.justicekn.webgame.Controller.Registe;

import com.justicekn.webgame.Bean.Registe.AccountRegisterBean;
import com.justicekn.webgame.Handler.Registe.AccountRegisterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class RegisterAccountToDataBase {

    @Autowired
    AccountRegisterHandler accountRegisterHandler;

    @RequestMapping("/register")
    public String reg(@Valid AccountRegisterBean bean, HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        return accountRegisterHandler.accountReg(bean);
    }
}
