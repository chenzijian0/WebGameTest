package com.justicekn.webgame.Handler.GameItem;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.WeaponAttributes;
import com.justicekn.webgame.Bean.GameItem.GetWeaponAndArmorBean;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetArmor {
    @Autowired
    GetWeaponAndArmorHandler getWeaponAndArmorHandler;


    public List<ArmorAttributes> getArmor(int id, HttpSession httpSession) {

        List<ArmorAttributes> armorBeans = new ArrayList<ArmorAttributes>();
        GetWeaponAndArmorBean[] weaponAndArmorBeans = getWeaponAndArmorHandler.getWeaponAndArmorHandler(id);
        for (GetWeaponAndArmorBean beans : weaponAndArmorBeans) {
            if (beans.getWeaponId() == null) {
                armorBeans.add(new ArmorAttributes(beans.getIdentifyId(), beans.getArmId(), (GamersEntity) httpSession.getAttribute("gamersEntity")));
            }
        }
        return armorBeans;
    }
}
