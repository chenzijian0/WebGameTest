package com.justicekn.webgame.DAO.Interface.GameItem;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DisassembleTheEquipment
{
    @Select("select equipmentType from userequipmentitem where id =  #{id} and  identifyId = #{identifyId} limit 1")
    int queryType(int id, int identifyId);

    @Delete("delete from userequipmentitem where identifyId = #{identifyId}")
    int destructionEquipment(int identifyId);

    @Select("select ARM_EXP from usergameattributes   where id = #{id} limit 1")
    int isArmUpgradeLevel(int id);

    @Select("select WAE_EXP from usergameattributes   where id = #{id} limit 1")
    int isWeaponUpgradeLevel(int id);

    @Update("update usergameattributes set ARM_EXP = ARM_EXP - #{exp} where id = #{id} limit 1")
    void IncreaseArmExperience(int exp ,int id);

    @Update("update usergameattributes set WAE_EXP = WAE_EXP - #{exp} where id = #{id} limit 1")
    void IncreaseWeaponExperience(int exp ,int id);

    @Update("update usergameattributes set ARM_LEVEL = ARM_LEVEL + 1, ARM_EXP = ARM_EXP + ARM_LEVEL * 5  where id = #{id} limit 1")
    void armUpgradeLevel(int id);

    @Update("update usergameattributes set WEA_LEVEL = WEA_LEVEL + 1 , WAE_EXP = WAE_EXP + WEA_LEVEL * 5  where id = #{id} limit 1")
    void weaponUpgradeLevel(int id);

}
