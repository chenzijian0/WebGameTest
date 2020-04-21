package com.justicekn.webgame.DAO.Interface.GameItem;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface UserEquipmentArm
{
    @Update("update usergameattributes set ARM = #{identifyId} where id = #{id}")
    public int EquipmentArm(String identifyId , int id);
}
