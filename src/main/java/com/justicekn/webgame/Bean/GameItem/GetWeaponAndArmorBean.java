package com.justicekn.webgame.Bean.GameItem;

public class GetWeaponAndArmorBean {
private int id;
private String weaponId = null;
private String armId = null;
private int identifyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(String weaponId) {
        this.weaponId = weaponId;
    }

    public String getArmId() {
        return armId;
    }

    public void setArmId(String armId) {
        this.armId = armId;
    }

    public int getIdentifyId() {
        return identifyId;
    }

    public void setIdentifyId(int identifyId) {
        this.identifyId = identifyId;
    }
}
