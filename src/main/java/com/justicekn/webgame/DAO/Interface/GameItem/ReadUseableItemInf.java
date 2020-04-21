package com.justicekn.webgame.DAO.Interface.GameItem;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReadUseableItemInf
{
    @Select("select CARTOON1 from usergameattributes where id = #{id} limit 1")
    int read_CARTOON1_Inf(int id);
    @Select("select CARTOON2 from usergameattributes where id = #{id} limit 1")
    int read_CARTOON2_Inf(int id);
    @Select("select ROOM_KEY from usergameattributes where id = #{id} limit 1")
    int read_ROOM_KEY_Inf(int id);
    @Select("select CD from usergameattributes where id = #{id} limit 1")
    int read_CD_Inf(int id);
    @Select("select MED from usergameattributes where id = #{id} limit 1")
    int read_MED_Inf(int id);
    @Select("select COUPON from usergameattributes where id = #{id} limit 1")
    int read_COUPON_Inf(int id);

    @Delete("delete  FROM userusableitem where identifyId = #{identifyId} ")
    int deleteItem(int identifyId);

    @Update("update usergameattributes set CARTOON1 = CARTOON1 + 1 where  id = #{id} ")
    int updateCARTOON1(int id);
    @Update("update usergameattributes set CARTOON2 = CARTOON2 + 1 where  id = #{id} ")
    int updateCARTOON2(int id);
    @Update("update usergameattributes set ROOM_KEY = ROOM_KEY + 1 where  id = #{id} ")
    int updateROOM_KEY(int id);
    @Update("update usergameattributes set CD = CD + 1 where  id = #{id} ")
    int updateCD(int id);
    @Update("update usergameattributes set MED = MED + 1 where  id = #{id} ")
    int updateMED(int id);
    @Update("update usergameattributes set COUPON = COUPON + 1 where  id = #{id} ")
    int updateCOUPON(int id);

}
