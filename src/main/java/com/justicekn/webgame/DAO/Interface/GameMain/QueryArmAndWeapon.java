package com.justicekn.webgame.DAO.Interface.GameMain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QueryArmAndWeapon
{
    @Select("select ARM from usergameattributes where id = #{id}")
    public String queryArm(int id );
    @Select("select WEA from usergameattributes where id = #{id}")
    public String queryWeapon(int id );

}
