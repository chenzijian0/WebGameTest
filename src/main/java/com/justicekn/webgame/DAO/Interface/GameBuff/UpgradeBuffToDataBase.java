package com.justicekn.webgame.DAO.Interface.GameBuff;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UpgradeBuffToDataBase {
    @Update("update usergameattributes SET BUFF = #{buff} where id = #{id} limit 1")
    public int upgradeBuff(int id, double buff);

    @Update("update usergameattributes SET KFB = KFB - #{choseLevel} where id = #{id} limit 1")
    public int upgradeKfb(int id, int choseLevel);

}
