package com.justicekn.webgame.Handler.GameMain;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.WeaponAttributes;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import com.justicekn.webgame.DAO.Interface.GameMain.QueryEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class GetUseEquipment
{
    @Autowired
    QueryEquipment queryEquipment;

    public WeaponAttributes getUseWeapon(int id, HttpSession httpSession)
    {
        String weaponId = queryEquipment.queryWeapon(id);
      return   new WeaponAttributes(0, weaponId, (GamersEntity) httpSession.getAttribute("gamersEntity"));
    }

    public ArmorAttributes getUseArm(int id, HttpSession httpSession)
    {
        String armId = queryEquipment.queryArm(id);
        return new ArmorAttributes(0, armId, (GamersEntity) httpSession.getAttribute("gamersEntity"));
    }
}
