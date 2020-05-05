package com.justicekn.webgame.Controller.GameMain;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.WeaponAttributes;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import com.justicekn.webgame.DAO.Interface.GameMain.QueryChallengeTime;
import com.justicekn.webgame.Handler.GameBuff.GetBuffRankList;
import com.justicekn.webgame.Handler.GameMain.CanChallenge;
import com.justicekn.webgame.Handler.GameMain.GetUseEquipment;
import com.justicekn.webgame.Handler.Login.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyMain
{
    @Autowired
    LoginHandler loginHandler;
    @Autowired
    GetBuffRankList getBuffRankList;
    @Autowired
    CanChallenge canChallenge;
    @Autowired
    GetUseEquipment getUseEquipment;

    @RequestMapping("/GamePage/gameMain.html")
    public String getMyMainPage(HttpServletRequest request, HttpServletResponse response)
    {
        int id = (int) request.getSession().getAttribute("userId");
        //            获取用户游戏属性信息
        UserGameAttributes userGameAttributes = loginHandler.GetUserGameAttributes(id);
        request.getSession().setAttribute("userAttributesFromDataBase", userGameAttributes);
        //获取Buff信息
        double buffValue = getBuffRankList.getMyBuffValue(id);
        request.getSession().setAttribute("buffValue", buffValue);
        //
        GamersEntity gamersEntity = new GamersEntity(userGameAttributes, buffValue);
        request.getSession().setAttribute("gamersEntity", gamersEntity);

        //获取穿戴装备信息
        ArmorAttributes useArm = getUseEquipment.getUseArm(id, request.getSession());
        WeaponAttributes useWeapon = getUseEquipment.getUseWeapon(id, request.getSession());
        request.setAttribute("useArm",useArm);
        request.setAttribute("useWeapon",useWeapon);

        //查看是否能够进行挑战
        if (canChallenge.canChallenge(id))
        {
            request.setAttribute("canChallenge", false);
        }
        else
        {
            request.setAttribute("canChallenge", true);
        }
        return "GamePage/gameMain";
    }
}
