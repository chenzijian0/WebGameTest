package com.justicekn.webgame;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import com.justicekn.webgame.Bean.GameMain.ModifyAttributesBean;
import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import com.justicekn.webgame.Component.JwtTokenUtil;
import com.justicekn.webgame.Component.JWTConfiguration;
import com.justicekn.webgame.DAO.Interface.GameItem.ReadUseableItemInf;
import com.justicekn.webgame.DAO.Interface.GameMain.ModifyGamerAttributes;
import com.justicekn.webgame.DAO.Interface.GameMain.QueryChallengeTime;
import com.justicekn.webgame.Handler.GameBuff.GetBuffRankList;
import com.justicekn.webgame.Handler.GameItem.CalculateIsUsedSuccessfully;
import com.justicekn.webgame.Handler.GameItem.SellItemHandler;
import com.justicekn.webgame.Handler.Login.LoginHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
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

    @Test
    void TestArm()
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
        String weaponId = "424344244535533225433426542412";
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
        sellItemHandler.SellSuccess(1, 1, 37);
    }

    /***
     * 测试生成怪物
     */
    @Autowired
    UserGameAttributes userGameAttributes;

    @Test
    void monster()
    {
        for (int i = 1; i < 11; i++)
        {
            UserGameAttributes temp = userGameAttributes;
            temp.setSnh(i * 5);
            temp.setAgi(i * 2);
            temp.setPhy(i * 5);
            temp.setDex(i * 2);
            temp.setWis(i * 2);
            temp.setMnd(i * 2);
            GamersEntity gamersEntity = new GamersEntity(userGameAttributes, 0);
            System.out.println(gamersEntity);
        }


    }

    @Autowired
    QueryChallengeTime queryChallengeTime;

    @Test
    void queryTime()
    {
//        System.out.println(queryChallengeTiem.challengeTiem(37));
        Date d1 = queryChallengeTime.challengeTiem(37);
        Date d2 = queryChallengeTime.challengeTiem(45);
        System.out.println(d1);
        System.out.println(d1.before(new Date()));
    }

    @Autowired
    ModifyGamerAttributes modifyGamerAttributes;

    @Test
    void modify()
    {
        ModifyAttributesBean bean = new ModifyAttributesBean(1, 1, 1, 1, 1, 1);
        modifyGamerAttributes.updateGamerAttributes(bean.getSnh(), bean.getAgi(), bean.getPhy(), bean.getDex(), bean.getWis(), bean.getMnd(), 37);
    }


    @Autowired
    JWTConfiguration jwtConfiguration;

    @Test
    void JwtCreate()
    {

        String t = JwtTokenUtil.createJWT(37, "JusticeKn", "1", "NoName", jwtConfiguration);
        System.out.println(t);
        String name = JwtTokenUtil.getUsername(t, jwtConfiguration.getBase64Secret());
        String account = JwtTokenUtil.getUserAccount(t, jwtConfiguration.getBase64Secret());
        int id = JwtTokenUtil.getUserId(t, jwtConfiguration.getBase64Secret());
        System.out.println(name );
        System.out.println(account );
        System.out.println(id );
    }


}
