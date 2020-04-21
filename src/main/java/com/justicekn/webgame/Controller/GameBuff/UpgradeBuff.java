package com.justicekn.webgame.Controller.GameBuff;

import com.justicekn.webgame.DAO.Interface.GameBuff.UpgradeBuffToDataBase;
import com.justicekn.webgame.Handler.GameBuff.UpgradeBuffHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class UpgradeBuff
{
    @Autowired
    UpgradeBuffHandler upgradeBuffHandler;
    @Autowired
    UpgradeBuffToDataBase upgradeBuffToDataBase;

    @RequestMapping("/GamePage/UpgradeBuff")
    public void upgradeBuff(String upId, HttpSession httpSession, HttpServletResponse response,  int choseLevel) throws IOException
    {
        double oldBuffValue = (double) httpSession.getAttribute("buffValue");
        int id = (int) httpSession.getAttribute("userId");
//        boolean flag = upgradeBuffHandler.canBeUpgrade(upId, oldBuffValue);
        boolean flag = upgradeBuffHandler.enoughKfbToUpgrade((int) httpSession.getAttribute("userKfb"), choseLevel);
        if (flag)
        {
            int kfb = upgradeBuffHandler.upgradeKfb(upId,id,(int)httpSession.getAttribute("userKfb"));
            httpSession.setAttribute("userKfb",kfb);
            // 获取的新的buff值
            double result = upgradeBuffHandler.upgradeBuffValue(upId, oldBuffValue);
            // 与原来的对比 是否大于原值
            if (oldBuffValue < result) upgradeBuffToDataBase.upgradeBuff(id, result);
            response.sendRedirect("/GamePage/gameBuff.html");
        }
        else
        {
            /***
             *  等待进一步处理
             */
            response.sendRedirect("/error");
        }
    }
}
