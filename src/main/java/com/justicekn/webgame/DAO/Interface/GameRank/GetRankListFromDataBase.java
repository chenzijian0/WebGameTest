package com.justicekn.webgame.DAO.Interface.GameRank;

import com.justicekn.webgame.Bean.GameBuff.GamerBuffRankBean;
import com.justicekn.webgame.Bean.GameRank.GamerRankBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GetRankListFromDataBase {
    @Select("select @ranking:=@ranking+1 as rankingCount ,name ,FLOOR ,id from usergameattributes order by FLOOR DESC ")
    public GamerRankBean[] getRankList();

    @Select("select @ranking :=0")
    public int setValue();

    @Select("select @ranking:=@ranking+1 as rankingCount ,name ,BUFF ,id from usergameattributes order by BUFF DESC ")
    public GamerBuffRankBean[]  getBuffRankList();

    @Select("select BUFF from usergameattributes where id = #{id} limit 1")
    public double getMyBuffValue(int id);

}

