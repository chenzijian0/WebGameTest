package com.justicekn.webgame.Handler.GameMain;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.WeaponAttributes;
import com.justicekn.webgame.Bean.GameMain.BattleInf;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import com.justicekn.webgame.DAO.Interface.GameMain.Loot;
import com.justicekn.webgame.DAO.Interface.GameMain.QueryArmAndWeapon;
import com.justicekn.webgame.DAO.Interface.GameMain.QueryChallengeTime;
import com.justicekn.webgame.DAO.Interface.GameMain.QueryFloor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * 这里的 GamersEntity实例是由传入 UserGameAttributes 后生成的 , 但是其中的 health属性 却又是通过数据库读取得到的, 需要注意
 */
@Service
public class BattleSimulation
{
    @Autowired
    Loot loot;
    @Autowired
    UserGameAttributes userGameAttributes;
    @Autowired
    QueryFloor queryFloor;
    @Autowired
    BattleInf battleInf;
    @Autowired
    QueryArmAndWeapon queryArmAndWeapon;
    @Autowired
    QueryChallengeTime queryChallengeTime;

    public int monsterHeath;
    public int monsterSpeed;
    public int monsterAttack;
    public int userShield;
    public int offsetDex;
    public int offsetWis;
    public int offsetHeath;
    public WeaponAttributes userWeapon;
    public ArmorAttributes userArm;
    public int weaponType;
    public int challengeFloor;
    public boolean userWin = false;
    public boolean monsterWin = false;
    public int heathPercentage;
    public int remainingHp;
    public int totalHp;
    public String lootType;

    public GamersEntity generateMonster(int id)
    {
        challengeFloor = queryFloor.queryChallengeFloor(id);
        UserGameAttributes temp = userGameAttributes;
        if (challengeFloor <= 50)
        {
            temp.setSnh(challengeFloor * 5);
            temp.setPhy(challengeFloor * 5);
            temp.setAgi(challengeFloor * 2);
            temp.setDex(challengeFloor * 2);
            temp.setWis(challengeFloor * 2);
            temp.setMnd(challengeFloor);
        }
        else if (challengeFloor <= 100)
        {
            temp.setSnh(challengeFloor * 10);
            temp.setPhy(challengeFloor * 7);
            temp.setAgi(challengeFloor * 3);
            temp.setDex(challengeFloor * 3);
            temp.setWis(challengeFloor * 3);
            temp.setMnd(challengeFloor * 4);
        }
        else if (challengeFloor <= 150)
        {
            temp.setSnh(challengeFloor * 13);
            temp.setPhy(challengeFloor * 10);
            temp.setAgi(challengeFloor * 5);
            temp.setDex(challengeFloor * 6);
            temp.setWis(challengeFloor * 6);
            temp.setMnd(challengeFloor * 8);
        }
        else if (challengeFloor <= 200)
        {
            temp.setSnh(challengeFloor * 20);
            temp.setPhy(challengeFloor * 15);
            temp.setAgi(challengeFloor * 10);
            temp.setDex(challengeFloor * 10);
            temp.setWis(challengeFloor * 10);
            temp.setMnd(challengeFloor * 13);
        }
        else
        {
            temp.setSnh(challengeFloor * 20);
            temp.setPhy(challengeFloor * 15);
            temp.setAgi(challengeFloor * 10);
            temp.setDex(challengeFloor * 10);
            temp.setWis(challengeFloor * 10);
            temp.setMnd(challengeFloor * 13);

        }
        GamersEntity gamersEntity = new GamersEntity(userGameAttributes, 0);
        return gamersEntity;
    }

    public void init(GamersEntity monsterEntity, GamersEntity userEntity, int id, UserGameAttributes userGameAttributes)
    {
        String WeaId, ArmId;
        monsterHeath = monsterEntity.getTotalHeath();
        monsterSpeed = monsterEntity.getSpeed();
        monsterAttack = monsterEntity.getAttack();
        offsetDex = monsterEntity.getDex() / 3 + userEntity.getDex() / 3;
        offsetWis = monsterEntity.getWis() / 3 + userEntity.getWis() / 3;
        WeaId = queryArmAndWeapon.queryWeapon(id);
        ArmId = queryArmAndWeapon.queryArm(id);
        userWeapon = new WeaponAttributes(0, WeaId, userEntity);
        userArm = new ArmorAttributes(0, ArmId, userEntity);
        userShield = userArm.getShield();
        //战斗部分实际上并没有减血, 我们之后有时间再修复这个问题.(已修复)
        offsetHeath = monsterEntity.getTotalHeath() - userGameAttributes.getCd() * monsterEntity.getTotalHeath() / 100;
        monsterEntity.setHealth(offsetHeath);

        //属性抵消修正
        if (userEntity.getDex() - offsetDex < 0)
        {
            userEntity.setDex(0);
        }
        else
        {
            userEntity.setDex(userEntity.getDex() - offsetDex);
        }
        if (monsterEntity.getDex() - offsetDex < 0)
        {
            monsterEntity.setDex(0);
        }
        else
        {
            monsterEntity.setDex(monsterEntity.getDex() - offsetDex);
        }
        if (userEntity.getWis() - offsetWis < 0)
        {
            userEntity.setWis(0);
        }
        else
        {
            userEntity.setWis(userEntity.getWis() - offsetWis);
        }
        if (monsterEntity.getWis() - offsetWis < 0)
        {
            monsterEntity.setDex(0);
        }
        else
        {
            monsterEntity.setWis(monsterEntity.getWis() - offsetWis);
        }


        //这里进行武器对玩家属性的修正操作
        String substring = WeaId.substring(1, 2);
        switch (substring)
        {
            case "1":
                userEntity.setAttack(userEntity.getAttack() + userEntity.getSnh() + userEntity.getWis() + userEntity.getDex() + userEntity.getAgi());
                weaponType = 1;
                break;
            case "2":
                userEntity.setAttack(userEntity.getAttack() + userEntity.getAgi() * 2);
                userEntity.setSpeed(userEntity.getSpeed() + userEntity.getDex());
                weaponType = 2;
                break;
            case "3":
                userEntity.setTotalHeath(userEntity.getTotalHeath() - userEntity.getTotalHeath() / 10);
                weaponType = 3;
                break;
        }

    }

    public List<BattleInf> battleSimulation(int id, GamersEntity userEntity, UserGameAttributes userGameAttributes)
    {
        int attack;
        List<BattleInf> infs = new ArrayList<BattleInf>();
        GamersEntity monsterEntity = generateMonster(id);
        init(monsterEntity, userEntity, id, userGameAttributes);
        int userSpeed = 0, monsterSpeed = 0;
        userSpeed += userEntity.getSpeed();
        monsterSpeed += monsterEntity.getSpeed();
        userWin = false;
        monsterWin = false;
        while (userEntity.getHealth() > 0 && monsterEntity.getHealth() > 0)
        {
            battleInf.setUserSide(false);
            battleInf.setMonsterSide(false);
            battleInf.setUseSkill(false);
            battleInf.setCriticalHit(false);
            //玩家攻击
            if (userSpeed > monsterSpeed)
            {
                attack = userEntity.getAttack();
                //使用技能
                if (userWeapon.useSkill((double) userEntity.getWis() / (userEntity.getWis() + 90)))
                {
                    battleInf.setUseSkill(true);
                    switch (weaponType)
                    {
                        case 1:
                            attack += ((userEntity.getAttack() + userEntity.getSnh() + userEntity.getWis() + userEntity.getDex() + userEntity.getAgi()) * 2) + ((userEntity.getAttack() + userEntity.getSnh() + userEntity.getWis() + userEntity.getDex() + userEntity.getAgi()) * 2) * (userWeapon.getSkillCrit() + 1) / 100;
                            battleInf.setSkillInf("星爆气流斩");
                            break;
                        case 2:
                            attack += (userEntity.getAgi() * 3 + userEntity.getDex() * 7) + (userEntity.getAgi() * 3 + userEntity.getDex() * 7) * (userWeapon.getSkillCrit() + 1) / 100;
                            battleInf.setSkillInf("流星箭");
                            break;
                        case 3:
                            attack += (userEntity.getWis() * 25 - userEntity.getPhy() * 30) + (userEntity.getWis() * 25 - userEntity.getPhy() * 30) * (userWeapon.getSkillCrit() + 1) / 100;
                            battleInf.setSkillInf("元气弹");
                            break;
                    }
                }
                //暴击
                if (userWeapon.Crit((double) userEntity.getDex() / (userEntity.getDex() + 100)))
                {
                    battleInf.setCriticalHit(true);
                    attack = (int) (attack * 2 * userWeapon.getPhysicalCrit() / 100) + attack * 2;
                }

                attack = attack - (int) (attack * monsterEntity.getReduceDamage() / 100);
                monsterEntity.setHealth(monsterEntity.getHealth() - attack);
                battleInf.setBattleInf("对方受到" + String.valueOf(-attack) + "伤害");
                battleInf.setUserSide(true);
                BattleInf temp = new BattleInf();
                BeanUtils.copyProperties(battleInf, temp);
                infs.add(temp);
                monsterSpeed += monsterEntity.getSpeed();
            }
            //怪物攻击
            else
            {
                attack = monsterEntity.getAttack();
                // 虽然是使用的玩家的武器进行是否暴击和技能的判断 ,但是并不影响结果
                if (userWeapon.useSkill((double) monsterEntity.getWis() / (monsterEntity.getWis() + 90)))
                {
                    battleInf.setUseSkill(true);
                    battleInf.setSkillInf("狂暴怒吼");
                    attack += attack * 0.5;
                }
                if (userWeapon.Crit((double) monsterEntity.getDex() / (monsterEntity.getDex() + 100)))
                {
                    battleInf.setCriticalHit(true);
                    attack += attack;
                }
                //好吧不会回血了
                double time = (1 - ((double) userEntity.getHealth() / userEntity.getTotalHeath())) / 0.05;
                attack = attack - (int) (attack * userArm.getIncreaseDefense() * time / (userArm.getIncreaseDefense() * time + 150));
                attack = attack - (int) (attack * userEntity.getReduceDamage() / 100);
                userEntity.setHealth(userEntity.getHealth() - attack);
                battleInf.setBattleInf("你受到" + String.valueOf(-attack) + "伤害");
                battleInf.setMonsterSide(true);
                BattleInf temp = new BattleInf();
                BeanUtils.copyProperties(battleInf, temp);
                infs.add(temp);
                userSpeed += userEntity.getSpeed();
            }
        }
        //落败
        if (userEntity.getHealth() <= 0)
        {
            queryChallengeTime.ifChallengeFail(id);
            queryFloor.ChallengeFailed(id);
            battleInf.setBattleInf("你倒下了");
            monsterWin = true;
        }
        //战胜
        if (monsterEntity.getHealth() <= 0)
        {
            heathPercentage = 100 - (int) (userEntity.getHealth() / (double) userEntity.getTotalHeath() * 100);
            remainingHp = userEntity.getHealth();
            totalHp = userEntity.getTotalHeath();
            battleInf.setBattleInf("你胜利了");
            queryFloor.ChallengeSuccess(id);
            userWin = true;
            lootType = earnLoot(id);
        }


        return infs;

    }

    public String earnLoot(int id)
    {
        Random random = new Random();
        int i = random.nextInt(100);
        if (i < 50)
        {
            loot.addOrdinaryBox(id);
            return "普通盒子";
        }
        else if (i < 80)
        {
            loot.addLuckyBox(id);
            return "幸运盒子";
        }
        else if (i < 95)
        {
            loot.addRareBox(id);
            return "稀有盒子";
        }
        else if (i < 100)
        {
            loot.addLegendBox(id);
            return "传奇盒子";
        }
        return " ";
    }
}
