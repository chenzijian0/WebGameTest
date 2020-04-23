package com.justicekn.webgame.Bean.GameItem.EquipmentEntity;

import com.justicekn.webgame.Bean.GameMain.GamersEntity;

import java.util.ArrayList;
import java.util.Iterator;

/***
 * WeaponId 包含3个部分
 * 第一部分(表示装备稀有度) 第一位 1-5    分别对应 ： 普通，幸运，稀有，传奇，神秘
 * 第二部分(表示装备主属性) 占第一部分数值 位   每位1个字段
 *  ---第一字段 1-6 对应 攻击，速度，吸血，物穿，物理暴击伤害，技能暴击伤害
 * 第三部分(表示装备从属性) 占第一部分数值 * 3位 每位3个字段
 *  ---第一字段 1-6 对应 攻击，速度，吸血，物穿，物理暴击伤害，技能暴击伤害
 *  ---第二字段 对应加成    从属性，属性加成  1-7 对应 力量，敏捷，体质，灵活，智慧，意志,等级
 *  ---第三字段 2-8 对应加成 0.2 - 0.8 从属性加成
 */

public class WeaponAttributes {
    private int identifyId;
    private String weaponId;
    private int attack = 0;
    private int speed = 0;
    private double healthDrain = 0;
    private double penetration = 0;
    private double physicalCrit = 0;
    private double skillCrit = 0;
    private ArrayList<String> mainAttributes = new ArrayList<String>();
    private ArrayList<String> secondaryAttributes = new ArrayList<String>();
    private ArrayList<String> secondaryAttributesBonus = new ArrayList<String>();
    private ArrayList<String> weaponClass = new ArrayList<String>();
    private String weaponBonus = "";
    private String weaponClassName = "";
    private String weaponAttributes = "";
    private String weaponPrimaryAttributes = "";
    private String weaponSecondaryAttributes = "";
    private String ra = "";
    private String smAttribute=null;

    public ArrayList<String> getWeaponClass() {
        return weaponClass;
    }

    public void setWeaponClass(ArrayList<String> weaponClass) {
        this.weaponClass = weaponClass;
    }

    public int getIdentifyId() {
        return identifyId;
    }

    public void setIdentifyId(int identifyId) {
        this.identifyId = identifyId;
    }

    public WeaponAttributes(int identifyId, String weaponId, GamersEntity entity) {
        this.identifyId = identifyId;
        this.weaponId = weaponId;
        weaponAttributeBonus(entity);
        attributeToString();
    }

    public String getWeaponPrimaryAttributes() {
        return weaponPrimaryAttributes;
    }

    public String getWeaponBonus() {
        return weaponBonus;
    }

    public String getSmAttribute() {
        return smAttribute;
    }

    public void setSmAttribute(String smAttribute) {
        this.smAttribute = smAttribute;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void setWeaponBonus(String weaponBonus) {
        this.weaponBonus = weaponBonus;
    }

    public void setWeaponPrimaryAttributes(String weaponPrimaryAttributes) {
        this.weaponPrimaryAttributes = weaponPrimaryAttributes;
    }

    public String getWeaponSecondaryAttributes() {
        return weaponSecondaryAttributes;
    }

    public void setWeaponSecondaryAttributes(String weaponSecondaryAttributes) {
        this.weaponSecondaryAttributes = weaponSecondaryAttributes;
    }

    public String getWeaponClassName() {
        return weaponClassName;
    }

    public void setWeaponClassName(String weaponClassName) {
        this.weaponClassName = weaponClassName;
    }

    public String getWeaponAttributes() {
        return weaponAttributes;
    }

    public void setWeaponAttributes(String weaponAttributes) {
        this.weaponAttributes = weaponAttributes;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getHealthDrain() {
        return healthDrain;
    }

    public void setHealthDrain(double healthDrain) {
        this.healthDrain = healthDrain;
    }

    public double getPenetration() {
        return penetration;
    }

    public void setPenetration(double penetration) {
        this.penetration = penetration;
    }

    public double getPhysicalCrit() {
        return physicalCrit;
    }

    public void setPhysicalCrit(double physicalCrit) {
        this.physicalCrit = physicalCrit;
    }

    public double getSkillCrit() {
        return skillCrit;
    }

    public void setSkillCrit(double skillCrit) {
        this.skillCrit = skillCrit;
    }

    public String getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(String weaponId) {
        this.weaponId = weaponId;
    }

    public void attributeToString() {
        StringBuilder temp = new StringBuilder();
        Iterator<String> iterator = mainAttributes.iterator();
        Iterator<String> iterator1 = secondaryAttributes.iterator();
        Iterator<String> iterator2 = secondaryAttributesBonus.iterator();
        Iterator<String> iterator3 = weaponClass.iterator();
        while (iterator3.hasNext()) {
            weaponClassName += iterator3.next();
        }
        temp.append("主属性:&nbsp;&nbsp;");
        while (iterator.hasNext()) {
            String next = iterator.next();
            temp.append(next);
            temp.append("&nbsp;&nbsp;&nbsp;");
        }
        temp.append("\n<br>");
        temp.append("从属性:&nbsp;&nbsp;");
        while (iterator1.hasNext()) {
            String next1 = iterator1.next();
            String next2 = iterator2.next();
            temp.append(next1);
            temp.append(next2);
            temp.append("&nbsp;&nbsp;&nbsp;");
        }
        temp.append("\n<br>");
        weaponAttributes = temp.toString();
    }

    public void weaponAttributeBonus(GamersEntity entity) {
        //武器稀有度
        String rarity = weaponId.substring(0, 1);
        switch (rarity) {
            case "1":
                weaponClass.add("普通的");
                ra = "pt";
                getThatWeaponClass();
                for (int i = 0; i < 1; i++) {
                    weaponAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 2; i++) {
                    weaponAttributeThirdTag1Parsing(i * 1 * 3 + 2, entity);
                }
                break;
            case "2":
                weaponClass.add("幸运的");
                ra = "xy";
                getThatWeaponClass();
                for (int i = 0; i < 2; i++) {
                    weaponAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 4; i++) {
                    weaponAttributeThirdTag1Parsing(i * 1 * 3 + 3, entity);
                }
                break;
            case "3":
                weaponClass.add("稀有的");
                ra = "xiyou";
                getThatWeaponClass();
                for (int i = 0; i < 3; i++) {
                    weaponAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 6; i++) {
                    weaponAttributeThirdTag1Parsing(i * 1 * 3 + 4, entity);
                }
                break;
            case "4":
                weaponClass.add("传奇的");
                ra = "cq";
                getThatWeaponClass();
                for (int i = 0; i < 4; i++) {
                    weaponAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 8; i++) {
                    weaponAttributeThirdTag1Parsing(i * 1 * 3 + 5, entity);
                }
                break;
            case "5":
                weaponClass.add("神秘的");
                ra = "sm";
                getThatWeaponClass();
                for (int i = 0; i < 4; i++) {
                    weaponAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 8; i++) {
                    weaponAttributeThirdTag1Parsing(i * 1 * 3 + 5, entity);
                }
                mysteriousBonus(30);
                break;
        }
    }

    //设置神秘属性加成 尚未添加
    public void mysteriousBonus(int stringIndex) {

    }

    public void getThatWeaponClass() {
        String thatWeaponClass = weaponId.substring(1, 2);
        switch (thatWeaponClass) {
            case "1":
                weaponClass.add("长剑: ");
                weaponBonus = "- 攻击力+（力量敏捷智力属性*1），并替换技能破空斩（攻击力 + 全属性*2），每减少3%生命值增加1%攻击速度1%暴击几率1%技能释放几率";
                break;
            case "2":
                weaponClass.add("弓箭: ");
                weaponBonus = "- 暴击伤害+50%，每点敏捷+2攻击，每点灵活+1速度，并替换技能追风箭（攻击力 + 敏捷值 x 3 + 灵活值 x 7）";
                break;
            case "3":
                weaponClass.add("法杖: ");
                weaponBonus = "- 生命值-10% , 技能替换为法术爆弹(智力值*25 - 体质*30)";
                break;
        }
    }

    public void weaponAttributeThirdTag1Parsing(int stringIndex, GamersEntity entity) {
        String thirdTag = weaponId.substring(stringIndex + 1, stringIndex + 2);
        String attributeClass = weaponId.substring(stringIndex + 2, stringIndex + 3);
        String boostValue = weaponId.substring(stringIndex + 3, stringIndex + 4);
        double result = weaponAttributeThirdTag2Parsing(attributeClass, boostValue, entity);
        result /= 1000;
        result += 1;
        switch (thirdTag) {
            case "1"://攻击
                attack = (int) (attack * result);
                secondaryAttributes.add("攻击(");
                break;
            case "2"://速度
                speed = (int) (speed * result);
                secondaryAttributes.add("速度(");
                break;
            case "3"://吸血
                healthDrain = (int) (healthDrain * result);
                secondaryAttributes.add("吸血(");
                break;
            case "4"://穿透
                penetration = (int) (penetration * result);
                secondaryAttributes.add("穿透(");
                break;
            case "5"://物理暴击伤害
                physicalCrit = (int) (physicalCrit * result);
                secondaryAttributes.add("物理暴击伤害(");
                break;
            case "6"://技能暴击伤害
                skillCrit = (int) (skillCrit * result);
                secondaryAttributes.add("技能暴击伤害(");
                break;
        }
    }

    public int weaponAttributeThirdTag2Parsing(String attributeClass, String boostValue, GamersEntity entity) {
        switch (attributeClass) {
            case "1"://力量
                secondaryAttributesBonus.add("力量*0." + boostValue + "%)");
                return Math.round(entity.getSnh() * Integer.parseInt(boostValue));
            case "2"://敏捷
                secondaryAttributesBonus.add("敏捷*0." + boostValue + "%)");
                return Math.round(entity.getAgi() * Integer.parseInt(boostValue));
            case "3"://体力
                secondaryAttributesBonus.add("体力*0." + boostValue + "%)");
                return Math.round(entity.getPhy() * Integer.parseInt(boostValue));
            case "4"://灵活
                secondaryAttributesBonus.add("灵活*0." + boostValue + "%)");
                return Math.round(entity.getDex() * Integer.parseInt(boostValue));
            case "5"://智慧
                secondaryAttributesBonus.add("智慧*0." + boostValue + "%)");
                return Math.round(entity.getWis() * Integer.parseInt(boostValue));
            case "6"://意志
                secondaryAttributesBonus.add("意志*0." + boostValue + "%)");
                return Math.round(entity.getMnd() * Integer.parseInt(boostValue));
            case "7"://等级
                secondaryAttributesBonus.add("人物等级*3*0." + boostValue + "%)");
                return Math.round(entity.getLevel() * 3 * Integer.parseInt(boostValue));
        }
        return 0;
    }

    //StringIndex 共有几个字符需要解析
    public void weaponAttributeSecondTagParsing(int stringIndex, GamersEntity entity) {
        String secondTag = weaponId.substring(stringIndex + 1, stringIndex + 2);
        switch (secondTag) {
            case "1"://攻击
                attack += entity.getWea_level() * 5;
                mainAttributes.add("攻击(等级*5)");
                break;
            case "2"://速度
                speed += entity.getWea_level() * 2;
                mainAttributes.add("速度(等级*2)");
                break;
            case "3"://吸血
                healthDrain += entity.getWea_level() * 3;
                mainAttributes.add("吸血(等级*1%)");
                break;
            case "4"://穿透
                penetration += entity.getWea_level();
                mainAttributes.add("穿透(等级*1%)");
                break;
            case "5"://物理暴击伤害
                physicalCrit += entity.getWea_level();
                mainAttributes.add("物理暴击伤害(等级*1%)");
                break;
            case "6"://技能暴击伤害
                skillCrit += entity.getWea_level();
                mainAttributes.add("技能暴击伤害(等级*1%)");
                break;
        }
    }

    @Override
    public String toString() {
        return "WeaponAttributes{" +
                "identifyId='" + identifyId + '\'' +
                ", weaponId='" + weaponId + '\'' +
                ", attack=" + attack +
                ", speed=" + speed +
                ", healthDrain=" + healthDrain +
                ", penetration=" + penetration +
                ", physicalCrit=" + physicalCrit +
                ", skillCrit=" + skillCrit +
                ", mainAttributes=" + mainAttributes +
                ", secondaryAttributes=" + secondaryAttributes +
                ", secondaryAttributesBonus=" + secondaryAttributesBonus +
                ", weaponClass=" + weaponClass +
                ", weaponClassName='" + weaponClassName + '\'' +
                ", weaponAttributes='" + weaponAttributes + '\'' +
                '}';
    }
}
