package com.justicekn.webgame.DAO.Interface.GameItem;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DisassembleTheEquipment
{
    @Select("select equipmentType from userequipmentitem where id =  #{id} and  identifyId = #{identifyId} limit 1")
    int queryType(int id, int identifyId);

    @Delete("delete from userequipmentitem where identifyId = #{identifyId}")
    int destructionEquipment(int identifyId );
}
