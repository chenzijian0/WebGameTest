package com.justicekn.webgame.DAO.Interface.GameItem;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserEquipmentWeapons
{
    @Update("update usergameattributes set WEA = #{identifyId} where id = #{id}")
    public int EquipmentWeapons(String identifyId , int id);
}
