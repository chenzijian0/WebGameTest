package com.justicekn.webgame;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.WeaponAttributes;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import com.justicekn.webgame.Handler.GameBuff.GetBuffRankList;
import com.justicekn.webgame.Handler.Login.LoginHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class WebgameApplicationTests {
    @Autowired
    LoginHandler loginHandler;
    @Autowired
    GetBuffRankList getBuffRankList;

    @Test
    void contextLoads() {
        int id = 37;
        String account = "1";
        //            获取用户游戏属性信息
        UserGameAttributes userGameAttributes = loginHandler.GetUserGameAttributes(id);
//获取Buff信息
        double buffValue = getBuffRankList.getMyBuffValue(id);
//计算属性
        GamersEntity gamersEntity = new GamersEntity(userGameAttributes, buffValue);
        System.out.println(gamersEntity);

        //生成一个WeaponId
        Random random = new Random();
        StringBuilder weaponId = new StringBuilder();
        weaponId.append(2);
        weaponId.append(2);
        weaponId.append(2);
        weaponId.append(5);
        weaponId.append(448);
        weaponId.append(126);
        weaponId.append(238);
        weaponId.append(256);
        System.out.println(weaponId);
        WeaponAttributes attributes = new WeaponAttributes(123,weaponId.toString(),gamersEntity);
        System.out.println(attributes.toString());
        System.out.println(attributes.getWeaponClassName());
        System.out.println(attributes.getWeaponAttributes());

    }

    @Test
    void Test() {
        int id = 37;
        String account = "1";
        //            获取用户游戏属性信息
        UserGameAttributes userGameAttributes = loginHandler.GetUserGameAttributes(id);
//获取Buff信息
        double buffValue = getBuffRankList.getMyBuffValue(id);
//计算属性
        GamersEntity gamersEntity = new GamersEntity(userGameAttributes, buffValue);
        System.out.println(gamersEntity);

        //生成一个WeaponId
        Random random = new Random();
        StringBuilder weaponId = new StringBuilder();
        weaponId.append(2);
        weaponId.append(3);
        weaponId.append(2);
        weaponId.append(5);
        weaponId.append(448);
        weaponId.append(126);
        weaponId.append(238);
        weaponId.append(256);
        System.out.println(weaponId);
        ArmorAttributes attributes = new ArmorAttributes(123,weaponId.toString(), gamersEntity);
        System.out.println(attributes.toString());
        System.out.println(attributes.getArmorClassName());
        System.out.println(attributes.getArmorAttributes());

    }

}
