package com.justicekn.webgame.DAO.Interface.GameMain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QueryEquipment
{
    @Select("select ARM from usergameattributes where id = #{id} limit 1")
    String queryArm(int id);
    @Select("select WEA from usergameattributes where id = #{id} limit 1")
    String queryWeapon(int id);
}
