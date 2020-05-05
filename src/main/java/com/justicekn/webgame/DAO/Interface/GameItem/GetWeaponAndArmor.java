package com.justicekn.webgame.DAO.Interface.GameItem;

import com.justicekn.webgame.Bean.GameItem.GetWeaponAndArmorBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GetWeaponAndArmor {
    @Select("select * from userequipmentitem where id = #{id} order by identifyId DESC limit 10")
    public GetWeaponAndArmorBean[] getWeaponAndArmorBeans(int id);
}
