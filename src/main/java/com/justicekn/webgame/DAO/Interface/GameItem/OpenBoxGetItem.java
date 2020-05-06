package com.justicekn.webgame.DAO.Interface.GameItem;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Mapper
public interface OpenBoxGetItem
{
    @Insert("insert into userequipmentitem(id,weaponId,equipmentType) values (#{id} , #{itemId} , #{equipmentType})")
    public int openBoxToGetWeapon(int id, String itemId, int equipmentType);

    @Insert("insert into userequipmentitem(id,armId,equipmentType) values (#{id} , #{itemId} , #{equipmentType})")
    public int openBoxToGetArmor(int id, String itemId, int equipmentType);

    @Insert("insert into userusableitem(id,itemClass) values(#{id},#{itemClass})")
    public int addUsableItem(int id, String itemClass);

    @Select("select OrdinaryBox from usergameattributes where id = #{id} limit 1")
    public int isOrdinaryBoxEnough(int id);

    @Select("select LuckyBox from usergameattributes where id = #{id} limit 1")
    public int isLuckyBoxEnough(int id);

    @Select("select RareBox from usergameattributes where id = #{id} limit 1")
    public int isRareBoxEnough(int id);

    @Select("select LegendBox from usergameattributes where id = #{id} limit 1")
    public int isLegendBoxEnough(int id);

    @Select("select MysteryBox from usergameattributes where id = #{id} limit 1")
    public int isMysteryBoxEnough(int id);

    @Update("update usergameattributes set OrdinaryBox = OrdinaryBox - 1 where id = #{id} limit 1")
    public int reduceOrdinaryBox(int id);

    @Update("update usergameattributes set LuckyBox = LuckyBox - 1 where id = #{id} limit 1")
    public int reduceLuckyBox(int id);

    @Update("update usergameattributes set RareBox = RareBox - 1 where id = #{id} limit 1")
    public int reduceRareBox(int id);

    @Update("update usergameattributes set LegendBox = LegendBox - 1 where id = #{id} limit 1")
    public int reduceLegendBox(int id);

    @Update("update usergameattributes set MysteryBox = MysteryBox - 1 where id = #{id} limit 1")
    public int reduceMysteryBox(int id);

    @Update("update usergameattributes set level_exp = level_exp - #{expCount} where id = #{id}")
    public void openBoxToGetExp(int expCount, int id);

    @Update("update usergameattributes set level = level + 1 where id = #{id}")
    public void upgradeLevel(int id);

    @Update("update usergameattributes set level_exp = level_exp + level * 1000 where id = #{id}")
    public void upgradeLevelExp(int id);

    @Update("update usergameattributes set KFB = KFB + #{KfbCount} where id = #{id}")
    public void openBoxToGetKfb(int KfbCount , int id);

    @Select("select level_exp from usergameattributes where id = #{id}")
    public int isUpgradeLevel(int id);

    @Update("update usergameattributes set ASSIGNABLE = ASSIGNABLE + 5 where  id = #{id} limit 1")
    void addAttributePoints(int id);

    @Update("update usergameattributes set WEA = #{WEA} where  id = #{id} limit 1")
    void giveWea(String WEA ,int id);

    @Update("update usergameattributes set ARM = #{ARM} where  id = #{id} limit 1")
    void giveArm(String ARM ,int id);

}
