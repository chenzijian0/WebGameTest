package com.justicekn.webgame.Bean.GameItem.EquipmentEntity;

import com.justicekn.webgame.Bean.GameMain.GamersEntity;

import java.util.ArrayList;
import java.util.Iterator;

/***
 * ArmorId 包含4个部分
 * 第一部分(表示装备稀有度) 第一位 1-5    分别对应 ： 普通，幸运，稀有，传奇，神秘
 * 第二部分 表示 装备类型 1个字段  1-3 分别对应 布甲 , 皮甲 , 铠甲
 * 第三部分(表示装备主属性) 占第一部分数值 位   每位1个字段
 *  ---第一字段 1-6 对应 被攻击恢复生命, 护盾, 减血加防, 反伤, 暴击伤害减免. 技能伤害减免.
 * 第四部分(表示装备从属性) 占第一部分数值 * 3位 每位3个字段
 *  ---第一字段 1-6 对应 被攻击恢复生命, 护盾, 减血加防, 反伤, 暴击伤害减免. 技能伤害减免.
 *  ---第二字段 对应加成    从属性，属性加成  1-7 对应 力量，敏捷，体质，灵活，智慧，意志,等级
 *  ---第三字段 2-8 对应加成 0.2 - 0.8 从属性加成
 */

public class ArmorAttributes {
    private int identifyId;
    private String armorId;
    private int restoreLife = 0; //回血
    private int shield = 0; //护盾
    private double increaseDefense = 0; //加防
    private double antiInjury = 0; //反伤
    private double reduceCriticalDamage = 0; //爆减
    private double reduceSkillDamage = 0; //技减
    private ArrayList<String> mainAttributes = new ArrayList<String>();
    private ArrayList<String> secondaryAttributes = new ArrayList<String>();
    private ArrayList<String> secondaryAttributesBonus = new ArrayList<String>();
    private ArrayList<String> armorClass = new ArrayList<String>();
    private String armorClassName = "";
    private String armorAttributes = "";
    private String armorPrimaryAttributes = "";
    private String armorSecondaryAttributes = "";
    private String armorBonus = "";
    private String ra = "";
    private String smAttribute = null;
    public ArmorAttributes(int identifyId, String armorId, GamersEntity entity) {
        this.identifyId = identifyId;
        this.armorId = armorId;
        armorAttributeBonus(entity);
        attributeToString();
    }

    @Override
    public String toString() {
        return "ArmorAttributes{" +
                "identifyId='" + identifyId + '\'' +
                ", armorId='" + armorId + '\'' +
                ", restoreLife=" + restoreLife +
                ", shield=" + shield +
                ", increaseDefense=" + increaseDefense +
                ", antiInjury=" + antiInjury +
                ", reduceCriticalDamage=" + reduceCriticalDamage +
                ", reduceSkillDamage=" + reduceSkillDamage +
                ", mainAttributes=" + mainAttributes +
                ", secondaryAttributes=" + secondaryAttributes +
                ", secondaryAttributesBonus=" + secondaryAttributesBonus +
                ", armorClass=" + armorClass +
                ", armorClassName='" + armorClassName + '\'' +
                '}';
    }

    public String getArmorAttributes() {
        return armorAttributes;
    }

    public void setArmorAttributes(String armorAttributes) {
        this.armorAttributes = armorAttributes;
    }

    public int getIdentifyId() {
        return identifyId;
    }

    public String getSmAttribute() {
        return smAttribute;
    }

    public void setSmAttribute(String smAttribute) {
        this.smAttribute = smAttribute;
    }

    public void setIdentifyId(int identifyId) {
        this.identifyId = identifyId;
    }

    public String getArmorPrimaryAttributes() {
        return armorPrimaryAttributes;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(String armorBonus) {
        this.armorBonus = armorBonus;
    }

    public void setArmorPrimaryAttributes(String armorPrimaryAttributes) {
        this.armorPrimaryAttributes = armorPrimaryAttributes;
    }

    public String getArmorSecondaryAttributes() {
        return armorSecondaryAttributes;
    }

    public void setArmorSecondaryAttributes(String armorSecondaryAttributes) {
        this.armorSecondaryAttributes = armorSecondaryAttributes;
    }

    public String getArmorId() {
        return armorId;
    }

    public void setArmorId(String armorId) {
        this.armorId = armorId;
    }

    public int getRestoreLife() {
        return restoreLife;
    }

    public void setRestoreLife(int restoreLife) {
        this.restoreLife = restoreLife;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public double getIncreaseDefense() {
        return increaseDefense;
    }

    public String getArmorClassName() {
        return armorClassName;
    }

    public void setArmorClassName(String armorClassName) {
        this.armorClassName = armorClassName;
    }

    public void setIncreaseDefense(double increaseDefense) {
        this.increaseDefense = increaseDefense;
    }

    public double getAntiInjury() {
        return antiInjury;
    }

    public void setAntiInjury(double antiInjury) {
        this.antiInjury = antiInjury;
    }

    public double getReduceCriticalDamage() {
        return reduceCriticalDamage;
    }

    public void setReduceCriticalDamage(double reduceCriticalDamage) {
        this.reduceCriticalDamage = reduceCriticalDamage;
    }

    public ArrayList<String> getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(ArrayList<String> armorClass) {
        this.armorClass = armorClass;
    }

    public double getReduceSkillDamage() {
        return reduceSkillDamage;
    }

    public void setReduceSkillDamage(double reduceSkillDamage) {
        this.reduceSkillDamage = reduceSkillDamage;
    }

    public void attributeToString() {
        StringBuilder temp = new StringBuilder();
        Iterator<String> thatArmorClass = armorClass.iterator();
        Iterator<String> iterator = mainAttributes.iterator();
        Iterator<String> iterator1 = secondaryAttributes.iterator();
        Iterator<String> iterator2 = secondaryAttributesBonus.iterator();
        while (thatArmorClass.hasNext()) {
            String next = thatArmorClass.next();
            armorClassName += next;
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
        temp.append("\n");
        armorAttributes = temp.toString();
    }

    public void armorAttributeBonus(GamersEntity entity) {
        //武器稀有度
        String rarity = armorId.substring(0, 1);
        switch (rarity) {
            case "1":

                armorClass.add("普通的");
                ra = "pt";
                getThatArmorClass();
                for (int i = 0; i < 1; i++) {
                    armorAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 2; i++) {
                    armorAttributeThirdTag1Parsing(i * 1 * 3 + 2, entity);
                }
                break;
            case "2":

                armorClass.add("幸运的");
                ra = "xy";
                getThatArmorClass();
                for (int i = 0; i < 2; i++) {
                    armorAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 4; i++) {
                    armorAttributeThirdTag1Parsing(i * 1 * 3 + 3, entity);
                }
                break;
            case "3":

                armorClass.add("稀有的");
                ra = "xiyou";
                getThatArmorClass();
                for (int i = 0; i < 3; i++) {
                    armorAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 6; i++) {
                    armorAttributeThirdTag1Parsing(i * 1 * 3 + 4, entity);
                }
                break;
            case "4":

                armorClass.add("传奇的");
                ra = "cq";
                getThatArmorClass();
                for (int i = 0; i < 4; i++) {
                    armorAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 8; i++) {
                    armorAttributeThirdTag1Parsing(i * 1 * 3 + 5, entity);
                }
                break;
            case "5":

                armorClass.add("神秘的");
                ra = "sm";
                getThatArmorClass();
                for (int i = 0; i < 4; i++) {
                    armorAttributeSecondTagParsing(i + 1, entity);
                }
                for (int i = 0; i < 8; i++) {
                    armorAttributeThirdTag1Parsing(i * 1 * 3 + 6, entity);
                }
                mysteriousBonus(29);
                break;
        }
    }

    //设置神秘属性加成 尚未添加
    public void mysteriousBonus(int stringIndex) {

    }

    public void getThatArmorClass() {
        String thatArmorClass = armorId.substring(1, 2);
        switch (thatArmorClass) {
            case "1":
                armorClass.add("布甲: ");
                armorBonus = "- 技能伤害+10%";
                break;
            case "2":
                armorClass.add("皮甲: ");
                armorBonus = "- 暴击伤害+10%";
                break;
            case "3":
                armorClass.add("板甲: ");
                armorBonus = "- 意志+10%";
                break;
        }
    }

    public void armorAttributeThirdTag1Parsing(int stringIndex, GamersEntity entity) {
        String thirdTag = armorId.substring(stringIndex + 1, stringIndex + 2);
        String attributeClass = armorId.substring(stringIndex + 2, stringIndex + 3);
        String boostValue = armorId.substring(stringIndex + 3, stringIndex + 4);
        double result = armorAttributeThirdTag2Parsing(attributeClass, boostValue, entity);
        result /= 1000;
        result += 1;
        switch (thirdTag) {
            case "1"://被攻击恢复生命
                restoreLife = (int) (restoreLife * result);
                secondaryAttributes.add("回血(");
                break;
            case "2"://护盾
                shield = (int) (shield * result);
                secondaryAttributes.add("护盾(");
                break;
            case "3"://加防
                increaseDefense = (int) (increaseDefense * result);
                secondaryAttributes.add("加防(");
                break;
            case "4"://反伤
                antiInjury = (int) (antiInjury * result);
                secondaryAttributes.add("反伤(");
                break;
            case "5"://减少物理暴击伤害
                reduceCriticalDamage = (int) (reduceCriticalDamage * result);
                secondaryAttributes.add("爆减(");
                break;
            case "6"://减少技能暴击伤害
                reduceSkillDamage = (int) (reduceSkillDamage * result);
                secondaryAttributes.add("技减(");
                break;
        }
    }

    public int armorAttributeThirdTag2Parsing(String attributeClass, String boostValue, GamersEntity entity) {
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
    public void armorAttributeSecondTagParsing(int stringIndex, GamersEntity entity) {
        String secondTag = armorId.substring(stringIndex + 1, stringIndex + 2);
        switch (secondTag) {
            case "1"://被攻击恢复生命
                restoreLife += entity.getWea_level() * 5 + 100;
                mainAttributes.add("被攻击恢复生命 100+(等级X5)");
                break;
            case "2"://护盾
                shield += entity.getWea_level() * 20 + 500;
                mainAttributes.add("护盾 500+(等级X20)");
                break;
            case "3"://减血加防
                increaseDefense += entity.getWea_level();
                mainAttributes.add("每减少5%生命值获得额外意志(等级X1)");
                break;
            case "4"://反弹对方实际伤害
                antiInjury += (double) (entity.getWea_level() / 10);
                mainAttributes.add("反弹对方实际伤害15%+(等级X0.1%)");
                break;
            case "5"://减少物理暴击伤害
                reduceCriticalDamage += entity.getWea_level() * 10;
                mainAttributes.add("减少物理暴击伤害10%+(等级x10无护甲减伤)");
                break;
            case "6"://减少技能暴击伤害
                reduceSkillDamage += entity.getWea_level() * 10;
                mainAttributes.add("减少技能暴击伤害10%+(等级x10无护甲减伤)");
                break;
        }
    }

}
