package com.justicekn.webgame.DAO.Interface.GameMain;

import com.justicekn.webgame.Bean.GameMain.ModifyAttributesBean;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ModifyGamerAttributes
{
    @Select("select ASSIGNABLE from  usergameattributes where id = #{id} limit 1")
    int assignable(int id);

    @Update("update usergameattributes SET SNH = #{snh} ,AGI = #{agi},PHY = #{phy},DEX =#{dex} ,WIS  = #{wis} , MND = #{mnd} where  id = #{id} limit 1")
    void updateGamerAttributes(int snh,int agi,int phy,int dex,int wis,int mnd ,int id);
}
