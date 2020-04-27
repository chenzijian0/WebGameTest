package com.justicekn.webgame.Handler.GameMain;

import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.ArmorAttributes;
import com.justicekn.webgame.Bean.GameItem.EquipmentEntity.WeaponAttributes;
import com.justicekn.webgame.Bean.GameMain.BattleInf;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import com.justicekn.webgame.DAO.Interface.GameMain.QueryArmAndWeapon;
import com.justicekn.webgame.DAO.Interface.GameMain.QueryFloor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BattleSimulation
{
    @Autowired
    UserGameAttributes userGameAttributes;
    @Autowired
    QueryFloor queryFloor;
    @Autowired
    BattleInf battleInf;
    @Autowired
    QueryArmAndWeapon queryArmAndWeapon;

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

    public GamersEntity generateMonster(int id)
    {
        challengeFloor = queryFloor.queryChallengeFloor(id);
        UserGameAttributes temp = userGameAttributes;
        temp.setSnh(challengeFloor * 5);
        temp.setPhy(challengeFloor * 5);
        temp.setAgi(challengeFloor * 2);
        temp.setDex(challengeFloor * 2);
        temp.setWis(challengeFloor * 2);
        temp.setMnd(challengeFloor);
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
        //战斗部分实际上并没有减血, 我们之后有时间再修复这个问题.
        offsetHeath = monsterEntity.getTotalHeath() - userGameAttributes.getCd() * monsterEntity.getTotalHeath() / 100;

        //属性抵消修正
        userEntity.setDex(userEntity.getDex() - offsetDex);
        monsterEntity.setDex(monsterEntity.getDex() - offsetDex);
        userEntity.setWis(userEntity.getWis() - offsetWis);
        monsterEntity.setWis(monsterEntity.getWis() - offsetWis);


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
                            break;
                        case 2:
                            attack += (userEntity.getAgi() * 3 + userEntity.getDex() * 7) + (userEntity.getAgi() * 3 + userEntity.getDex() * 7) * (userWeapon.getSkillCrit() + 1) / 100;
                            break;
                        case 3:
                            attack += (userEntity.getWis() * 25 - userEntity.getPhy() * 30) + (userEntity.getWis() * 25 - userEntity.getPhy() * 30) * (userWeapon.getSkillCrit() + 1) / 100;
                            break;
                    }
                }
                //暴击
                if (userWeapon.Crit((double) userEntity.getDex() / (userEntity.getDex() + 100)))
                {
                    battleInf.setCriticalHit(true);
                    attack = (int) (attack * 2 * (userWeapon.getPhysicalCrit() + 1) / 100) + attack * 2;
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
                    attack += attack * 0.5;
                }
                if (userWeapon.Crit((double) monsterEntity.getDex() / (monsterEntity.getDex() + 100)))
                {
                    battleInf.setCriticalHit(true);
                    attack += attack;
                }
                //好吧不会回血了
                double time = (1 - ((double)userEntity.getHealth() / userEntity.getTotalHeath())) / 0.05;
                attack = attack - (int) (attack * userArm.getIncreaseDefense()*time/(userArm.getIncreaseDefense()*time+150));
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
        return infs;

    }
}
