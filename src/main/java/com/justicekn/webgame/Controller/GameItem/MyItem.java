package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.WeaponAttributes;
import com.justicekn.webgame.Bean.GameItem.MyBoxBean;
import com.justicekn.webgame.Bean.GameItem.UsableItemList;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import com.justicekn.webgame.Handler.GameBuff.GetBuffRankList;
import com.justicekn.webgame.Handler.GameItem.GetArmor;
import com.justicekn.webgame.Handler.GameItem.GetMyBox;
import com.justicekn.webgame.Handler.GameItem.GetUsableItems;
import com.justicekn.webgame.Handler.GameItem.GetWeapon;
import com.justicekn.webgame.Handler.Login.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyItem
{
    @Autowired
    GetMyBox getMyBox;
    @Autowired
    GetArmor getArmor;
    @Autowired
    GetWeapon getWeapon;
    @Autowired
    GetUsableItems getUsableItems;
    @Autowired
    LoginHandler loginHandler;
    @Autowired
    GetBuffRankList getBuffRankList;

    @RequestMapping("/GamePage/gameItem.html")
    public String getMyItem(HttpServletRequest request)
    {
        int id = (int) request.getSession().getAttribute("userId");
        //引用于 src\main\java\com\justicekn\webgame\Controller\GameMain\MyMain.java
        //            获取用户游戏属性信息
        UserGameAttributes userGameAttributes = loginHandler.GetUserGameAttributes(id);
        request.getSession().setAttribute("userAttributesFromDataBase", userGameAttributes);
        //获取Buff信息
        double buffValue = getBuffRankList.getMyBuffValue(id);
        request.getSession().setAttribute("buffValue", buffValue);
        //
        GamersEntity gamersEntity = new GamersEntity(userGameAttributes, buffValue);
        request.getSession().setAttribute("gamersEntity", gamersEntity);


        MyBoxBean myBox = getMyBox.getMyBox(id);
        request.setAttribute("myBox", myBox);
        List<WeaponAttributes> weaponList = getWeapon.getWeapon(id, request.getSession());
        List<ArmorAttributes> armorList = getArmor.getArmor(id, request.getSession());
        UsableItemList[] usableItems = getUsableItems.getUsableItems(id);
        request.setAttribute("weaponList", weaponList);
        request.setAttribute("armorList", armorList);
        request.setAttribute("usableItems", usableItems);

        return "GamePage/gameItem";
    }
}
