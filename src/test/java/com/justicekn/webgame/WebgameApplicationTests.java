package com.justicekn.webgame;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameItem.UsableItemList;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import com.justicekn.webgame.DAO.Interface.GameItem.ReadUseableItemInf;
import com.justicekn.webgame.Handler.GameBuff.GetBuffRankList;
import com.justicekn.webgame.Handler.GameItem.CalculateIsUsedSuccessfully;
import com.justicekn.webgame.Handler.GameItem.SellItemHandler;
import com.justicekn.webgame.Handler.Login.LoginHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class WebgameApplicationTests
{
    @Autowired
    LoginHandler loginHandler;
    @Autowired
    GetBuffRankList getBuffRankList;

    @Test
    void Test()
    {
        /***
         * 手动生成一个装备, 并检查 是否合乎设计要求
         * 检查完毕, 正常
         */
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
        ArmorAttributes attributes = new ArmorAttributes(123, weaponId.toString(), gamersEntity);
        System.out.println(attributes.toString());
        System.out.println(attributes.getArmorClassName());
        System.out.println(attributes.getArmorAttributes());

    }

    @Autowired
    ReadUseableItemInf readUseableItemInf;
    @Autowired
    CalculateIsUsedSuccessfully calculateIsUsedSuccessfully;

    @Test
    void UseProps()
    {
        /***
         *  进行10次 蕾米莉亚同人漫画 的使用测试,
         *  结果正常
         */
        for (int i = 0; i < 10; i++)
        {
            System.out.println(calculateIsUsedSuccessfully.calculateIsUsedSuccessfully(2, 37, i + 15));
        }
    }

    @Autowired
    SellItemHandler sellItemHandler;
    @Test
    /***
     * 测试道具的出售
     */
    void sellItem()
    {
        sellItemHandler.SellSuccess(1,1,37);
    }

    /***
     * 测试生成怪物
     */
    @Autowired
    UserGameAttributes userGameAttributes;
    @Test
    void monster()
    {
        for (int i = 1; i < 11 ; i++)
        {
            UserGameAttributes temp =  userGameAttributes;
            temp.setSnh(i*5);
            temp.setAgi(i*2);
            temp.setPhy(i*5);
            temp.setDex(i*2);
            temp.setWis(i*2);
            temp.setMnd(i*2);
            GamersEntity gamersEntity = new GamersEntity(userGameAttributes, 0);
            System.out.println(gamersEntity);
        }


    }
}
