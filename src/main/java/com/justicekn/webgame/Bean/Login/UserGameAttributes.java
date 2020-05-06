package com.justicekn.webgame.Bean.Login;

public class UserGameAttributes {
    private int level;
    private int level_exp;
    private int snh;//力量
    private int agi;//敏捷
    private int phy;//体质
    private int dex;//灵巧
    private int wis;//智力
    private int mnd;//意志
    private int luk;//幸运
    private int end;//耐力
    private String arm;
    private String wea;
    private double buff;
    private int floor;
    private int cartoon1;
    private int cartoon2;
    private int room_key;
    private int cd;
    private int med;
    private int coupon;
    private int arm_level;
    private int wea_level;
    private int arm_exp;
    private int wae_exp;
    private int id;
    private int assignable;
    private String name;

    public UserGameAttributes()
    {
    }

    public UserGameAttributes(int level, int level_exp, int snh, int agi, int phy, int dex, int wis, int mnd, int luk, int end, String arm, String wea, double buff, int floor, int cartoon1, int cartoon2, int room_key, int cd, int med, int coupon, int arm_level, int wea_level, int arm_exp, int wae_exp, int id, int assignable, String name)
    {
        this.level = level;
        this.level_exp = level_exp;
        this.snh = snh;
        this.agi = agi;
        this.phy = phy;
        this.dex = dex;
        this.wis = wis;
        this.mnd = mnd;
        this.luk = luk;
        this.end = end;
        this.arm = arm;
        this.wea = wea;
        this.buff = buff;
        this.floor = floor;
        this.cartoon1 = cartoon1;
        this.cartoon2 = cartoon2;
        this.room_key = room_key;
        this.cd = cd;
        this.med = med;
        this.coupon = coupon;
        this.arm_level = arm_level;
        this.wea_level = wea_level;
        this.arm_exp = arm_exp;
        this.wae_exp = wae_exp;
        this.id = id;
        this.assignable = assignable;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserGameAttributes{" +
                "snh=" + snh +
                ", agi=" + agi +
                ", phy=" + phy +
                ", dex=" + dex +
                ", wis=" + wis +
                ", nmd=" + mnd +
                ", luk=" + luk +
                ", end=" + end +
                ", arm='" + arm + '\'' +
                ", wea='" + wea + '\'' +
                ", buff=" + buff +
                ", floor=" + floor +
                ", cartoon1=" + cartoon1 +
                ", cartoon2=" + cartoon2 +
                ", room_key=" + room_key +
                ", cd=" + cd +
                ", mnd=" + med +
                ", coupon=" + coupon +
                ", arm_level=" + arm_level +
                ", wea_level=" + wea_level +
                ", arm_exp=" + arm_exp +
                ", wea_exp=" + wae_exp +
                ", id=" + id +
                ", assignable=" + assignable +
                ", name='" + name + '\'' +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel_exp() {
        return level_exp;
    }

    public void setLevel_exp(int level_exp) {
        this.level_exp = level_exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAssignable() {
        return assignable;
    }

    public void setAssignable(int assignable) {
        this.assignable = assignable;
    }

    public int getSnh() {
        return snh;
    }

    public void setSnh(int snh) {
        this.snh = snh;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getPhy() {
        return phy;
    }

    public void setPhy(int phy) {
        this.phy = phy;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getMnd() {
        return mnd;
    }

    public void setMnd(int mnd) {
        this.mnd = mnd;
    }

    public int getLuk() {
        return luk;
    }

    public void setLuk(int luk) {
        this.luk = luk;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getArm() {
        return arm;
    }

    public void setArm(String arm) {
        this.arm = arm;
    }

    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea;
    }

    public double getBuff() {
        return buff;
    }

    public void setBuff(double buff) {
        this.buff = buff;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCartoon1() {
        return cartoon1;
    }

    public void setCartoon1(int cartoon1) {
        this.cartoon1 = cartoon1;
    }

    public int getCartoon2() {
        return cartoon2;
    }

    public void setCartoon2(int cartoon2) {
        this.cartoon2 = cartoon2;
    }

    public int getRoom_key() {
        return room_key;
    }

    public void setRoom_key(int room_key) {
        this.room_key = room_key;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int getMed() {
        return med;
    }

    public void setMed(int med) {
        this.med = med;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public int getArm_level() {
        return arm_level;
    }

    public void setArm_level(int arm_level) {
        this.arm_level = arm_level;
    }

    public int getWea_level() {
        return wea_level;
    }

    public void setWea_level(int wea_level) {
        this.wea_level = wea_level;
    }

    public int getArm_exp() {
        return arm_exp;
    }

    public void setArm_exp(int arm_exp) {
        this.arm_exp = arm_exp;
    }

    public int getWae_exp() {
        return wae_exp;
    }

    public void setWae_exp(int wae_exp) {
        this.wae_exp = wae_exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
