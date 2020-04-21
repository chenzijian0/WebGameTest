package com.justicekn.webgame.DAO.Interface.GameItem;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Mapper
public interface OpenBoxGetItem
{
    @Insert("insert into userEquipmentItem(id,weaponId) values (#{id} , #{itemId})")
    public int openBoxToGetWeapon(int id, String itemId);

    @Insert("insert into userEquipmentItem(id,armId) values (#{id} , #{itemId})")
    public int openBoxToGetArmor(int id, String itemId);

    @Insert("insert into userUsableItem(id,itemClass) values(#{id},#{itemClass})")
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

    @Update("update userGameAttributes set OrdinaryBox = OrdinaryBox - 1 where id = #{id} limit 1")
    public int reduceOrdinaryBox(int id);

    @Update("update userGameAttributes set LuckyBox = LuckyBox - 1 where id = #{id} limit 1")
    public int reduceLuckyBox(int id);

    @Update("update userGameAttributes set RareBox = RareBox - 1 where id = #{id} limit 1")
    public int reduceRareBox(int id);

    @Update("update userGameAttributes set LegendBox = LegendBox - 1 where id = #{id} limit 1")
    public int reduceLegendBox(int id);

    @Update("update userGameAttributes set MysteryBox = MysteryBox - 1 where id = #{id} limit 1")
    public int reduceMysteryBox(int id);


}
