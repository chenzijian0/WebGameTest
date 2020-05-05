package com.justicekn.webgame.Bean.GameMain;

public class ModifyAttributesBean
{
    private int snh;
    private int agi;
    private int phy;
    private int dex;
    private int wis;
    private int mnd;

    public ModifyAttributesBean()
    {
    }

    public ModifyAttributesBean(int snh, int agi, int phy, int dex, int wis, int mnd)
    {
        this.snh = snh;
        this.agi = agi;
        this.phy = phy;
        this.dex = dex;
        this.wis = wis;
        this.mnd = mnd;
    }

    @Override
    public String toString()
    {
        return "ModifyAttributesBean{" + "snh=" + snh + ", agi=" + agi + ", phy=" + phy + ", dex=" + dex + ", wis=" + wis + ", mnd=" + mnd + '}';
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
}
