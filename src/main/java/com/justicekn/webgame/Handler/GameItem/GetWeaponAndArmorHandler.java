package com.justicekn.webgame.Handler.GameItem;

import com.justicekn.webgame.Bean.GameItem.GetWeaponAndArmorBean;
import com.justicekn.webgame.DAO.Interface.GameItem.GetWeaponAndArmor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetWeaponAndArmorHandler {
    @Autowired
    GetWeaponAndArmor getWeaponAndArmor;

    public GetWeaponAndArmorBean[] getWeaponAndArmorHandler(int id){
        return getWeaponAndArmor.getWeaponAndArmorBeans(id);
    }

}
