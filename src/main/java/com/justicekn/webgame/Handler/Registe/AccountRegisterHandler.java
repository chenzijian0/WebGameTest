package com.justicekn.webgame.Handler.Registe;

import com.justicekn.webgame.Bean.Registe.AccountRegisterBean;
import com.justicekn.webgame.DAO.Interface.Registe.CheckAtRegistration;
import com.justicekn.webgame.DAO.Interface.Registe.RegisterAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRegisterHandler
{
    @Autowired
//            注册账号使用的SQL接口
            RegisterAccount registerAccount;
    @Autowired
//            查询账号是否重复使用的接口
            CheckAtRegistration checkAtRegistration;

    Logger logger = LoggerFactory.getLogger(getClass());

    public String accountReg(AccountRegisterBean bean)
    {
//        从查询账号是否重复
        int nameCount = checkAtRegistration.findName(bean.getName());
        int accountCount = checkAtRegistration.findAccount(bean.getAccount());
        if (nameCount == 0 && accountCount == 0)
        {
            logger.info("注册成功 用户名为:{}    账号为:{}", bean.getName(), bean.getAccount());
            registerAccount.reg(bean.getName(), bean.getAccount(), bean.getPwd());
            int userId = registerAccount.findAccountAtDataBase(bean.getAccount());
            registerAccount.userGameAttributesRegiste(userId, bean.getName());
            return "OK";
        }
        else
        {
            if (nameCount != 0)
            {
                logger.info("用户名重复");
                return "用户名重复";
            }
            if (accountCount != 0)
            {
                logger.info("账号重复");
                return "账号重复";
            }
            return "NO";
        }
    }
}
