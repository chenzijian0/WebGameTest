package com.justicekn.webgame.DAO.Interface.GameMain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Mapper
public interface Loot
{
    @Update("update usergameattributes set OrdinaryBox = OrdinaryBox + 1 where id = #{id}")
    public int addOrdinaryBox(int id);
    @Update("update usergameattributes set LuckyBox = LuckyBox + 1 where id = #{id}")
    public int addLuckyBox(int id);
    @Update("update usergameattributes set RareBox = RareBox + 1 where id = #{id}")
    public int addRareBox(int id);
    @Update("update usergameattributes set LegendBox = LegendBox + 1 where id = #{id}")
    public int addLegendBox(int id);
}
