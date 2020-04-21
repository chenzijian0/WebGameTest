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
public class GetWeapon {
    @Autowired
    GetWeaponAndArmorHandler getWeaponAndArmorHandler;


    public List<WeaponAttributes> getWeapon(int id, HttpSession httpSession) {

        List<WeaponAttributes> weaponBeans = new ArrayList<WeaponAttributes>();
        GetWeaponAndArmorBean[] weaponAndArmorBeans = getWeaponAndArmorHandler.getWeaponAndArmorHandler(id);
        for (GetWeaponAndArmorBean beans : weaponAndArmorBeans) {
            if (beans.getWeaponId() != null) {
                weaponBeans.add(new WeaponAttributes(beans.getIdentifyId(), beans.getWeaponId(), (GamersEntity) httpSession.getAttribute("gamersEntity")));
            }
        }
        return weaponBeans;
    }
}
