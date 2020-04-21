package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.WeaponAttributes;
import com.justicekn.webgame.Bean.GameItem.MyBoxBean;
import com.justicekn.webgame.Bean.GameItem.UsableItemList;
import com.justicekn.webgame.Handler.GameItem.GetArmor;
import com.justicekn.webgame.Handler.GameItem.GetMyBox;
import com.justicekn.webgame.Handler.GameItem.GetUsableItems;
import com.justicekn.webgame.Handler.GameItem.GetWeapon;
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

    @RequestMapping("/GamePage/gameItem.html")
    public String getMyItem(HttpServletRequest request)
    {
        int id = (int) request.getSession().getAttribute("userId");
        MyBoxBean myBox = getMyBox.getMyBox(id);
        request.setAttribute("myBox", myBox);
        List<WeaponAttributes> weaponList = getWeapon.getWeapon(id, request.getSession());
        List<ArmorAttributes> armorList = getArmor.getArmor(id, request.getSession());
        UsableItemList[] usableItems = getUsableItems.getUsableItems(id);
        request.setAttribute("weaponList", weaponList);
        request.setAttribute("armorList", armorList);
        request.setAttribute("usableItems", usableItems);

        return "/GamePage/gameItem";
    }
}
