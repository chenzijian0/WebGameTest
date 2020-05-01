package com.justicekn.webgame.Bean.GameMain;

import com.justicekn.webgame.Bean.Login.UserGameAttributes;

/***
 * 这是一个十分愚蠢的Class  为何我不继承 UserGameAttributes.java 呢?
 * 虽然 名为GamersEntity  但是 实际上不能作为战斗中传入的实体参数
 * 战斗时 使用的实体参数 另外创建
 *
 * 这里的 GamersEntity实例是由传入 UserGameAttributes 后生成的 , 但是其中的 health属性 却又是通过数据库读取得到的, 需要注意
 */
public class GamersEntity
{
    private int health;
    private int level;
    private int level_exp;
    private int arm_level;
    private int wea_level;
    private int snh;
    private int agi;
    private int phy;
    private int dex;
    private int wis;
    private int mnd;
    private int luk;
    private int end;
    private int totalHeath;
    private int speed;
    private double reduceDamage;
    private int attack;

    @Override
    public String toString()
    {
        return "GamersEntity{" + "level=" + level + ", level_exp=" + level_exp + ", arm_level=" + arm_level + ", wea_level=" + wea_level + ", snh=" + snh + ", agi=" + agi + ", phy=" + phy + ", dex=" + dex + ", wis=" + wis + ", mnd=" + mnd + ", luk=" + luk + ", end=" + end + ", totalHeath=" + totalHeath + ", speed=" + speed + ", reduceDamage=" + reduceDamage + ", attack=" + attack + '}';
    }

    public GamersEntity(UserGameAttributes attributes, double buffValue)
    {
        snh = (int) Math.round(attributes.getSnh() + attributes.getSnh() * buffValue / 100 + attributes.getCartoon1() + attributes.getMed() * 5);
        agi = (int) Math.round(attributes.getAgi() + attributes.getAgi() * buffValue / 100 + attributes.getCartoon2() + attributes.getMed() * 5);
        phy = (int) Math.round(attributes.getPhy() + attributes.getPhy() * buffValue / 100 + attributes.getCartoon1() + attributes.getMed() * 5);
        dex = (int) Math.round(attributes.getDex() + attributes.getDex() * buffValue / 100 + attributes.getCartoon2() + attributes.getMed() * 5);
        wis = (int) Math.round(attributes.getWis() + attributes.getWis() * buffValue / 100 + attributes.getMed() * 5);
        mnd = (int) Math.round(attributes.getMnd() + attributes.getMnd() * buffValue / 100 + attributes.getMed() * 5);
        luk = (int) Math.round(attributes.getLuk() + attributes.getLuk() * buffValue / 100);
        end = (int) Math.round(attributes.getEnd() + attributes.getEnd() * buffValue / 100);
        level = attributes.getLevel();
        level_exp = attributes.getLevel_exp();
        wea_level = attributes.getWea_level();
        arm_level = attributes.getArm_level();
        totalHeath = phy * 20;
        speed = agi * 2;
        reduceDamage = (double) Math.round((double) mnd / (mnd + 150) * 10000) / 100;
        health = totalHeath;  //这是暂时的生成时的规定 仅为了测试使用 , 在实际情况下, health的值将会读取数据库后,调用setHealth()方法写入
        attack = snh * 5;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getLevel_exp()
    {
        return level_exp;
    }

    public void setLevel_exp(int level_exp)
    {
        this.level_exp = level_exp;
    }

    public int getArm_level()
    {
        return arm_level;
    }

    public void setArm_level(int arm_level)
    {
        this.arm_level = arm_level;
    }

    public int getWea_level()
    {
        return wea_level;
    }

    public void setWea_level(int wea_level)
    {
        this.wea_level = wea_level;
    }

    public int getSnh()
    {
        return snh;
    }

    public void setSnh(int snh)
    {
        this.snh = snh;
    }

    public int getAgi()
    {
        return agi;
    }

    public void setAgi(int agi)
    {
        this.agi = agi;
    }

    public int getPhy()
    {
        return phy;
    }

    public void setPhy(int phy)
    {
        this.phy = phy;
    }

    public int getDex()
    {
        return dex;
    }

    public void setDex(int dex)
    {
        this.dex = dex;
    }

    public int getWis()
    {
        return wis;
    }

    public void setWis(int wis)
    {
        this.wis = wis;
    }

    public int getMnd()
    {
        return mnd;
    }

    public void setMnd(int mnd)
    {
        this.mnd = mnd;
    }

    public int getLuk()
    {
        return luk;
    }

    public void setLuk(int luk)
    {
        this.luk = luk;
    }

    public int getEnd()
    {
        return end;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }

    public int getTotalHeath()
    {
        return totalHeath;
    }

    public void setTotalHeath(int totalHeath)
    {
        this.totalHeath = totalHeath;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public double getReduceDamage()
    {
        return reduceDamage;
    }

    public void setReduceDamage(double reduceDamage)
    {
        this.reduceDamage = reduceDamage;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }
}
